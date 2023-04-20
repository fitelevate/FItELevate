package com.knit.fitelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class update_profile extends AppCompatActivity {
    Button updateprofile, update_button;
    private ImageView avatarImageView;
    private static final int PICK_IMAGE_REQUEST = 1;

    EditText name_field, height_field, weight_field, age_field, mobile_field, address_field;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    String uid=user.getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        // Add the windowSoftInputMode attribute to adjust the window when the keyboard is shown
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        updateprofile=findViewById(R.id.update_image_button);
        avatarImageView=findViewById(R.id.avatar_image);

        name_field = findViewById(R.id.name_field);
        height_field = findViewById(R.id.height_field);
        weight_field = findViewById(R.id.weight_field);
        age_field = findViewById(R.id.age_field);
        mobile_field = findViewById(R.id.mobile_field);
        address_field = findViewById(R.id.address_field);
        radioGroup = findViewById(R.id.gender_field);
        update_button = findViewById(R.id.update_button);

        //Fetch User Details
        Query checkUser = FirebaseDatabase.getInstance().getReference("User").orderByKey().equalTo(uid);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String name = snapshot.child(uid).child("name").getValue().toString();
                    String height = snapshot.child(uid).child("height").getValue().toString();
                    String weight = snapshot.child(uid).child("weight").getValue().toString();
                    String age = snapshot.child(uid).child("age").getValue().toString();
                    String mobile = snapshot.child(uid).child("mobile").getValue().toString();
                    String address = snapshot.child(uid).child("address").getValue().toString();
                    String gender = snapshot.child(uid).child("gender").getValue().toString();
                    name_field.setText(name);
                    height_field.setText(height);
                    weight_field.setText(weight);
                    age_field.setText(age);
                    mobile_field.setText(mobile);
                    address_field.setText(address);
                    if(gender.equals("Male")){
                        radioGroup.check(R.id.male_radio_button);
                    }
                    else {
                        radioGroup.check(R.id.female_radio_button);
                    }

                }
                else {
                    //Toast.makeText(update_profile.this, "User Details Not Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(update_profile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name_field.getText().toString();
                String heightStr = height_field.getText().toString();
                String weightStr = weight_field.getText().toString();
                String ageStr = age_field.getText().toString();
                String mobileStr = mobile_field.getText().toString();
                String addressStr = address_field.getText().toString();
                if(!TextUtils.isEmpty(nameStr) && !TextUtils.isEmpty(heightStr) && !TextUtils.isEmpty(weightStr) && !TextUtils.isEmpty(ageStr) && !TextUtils.isEmpty(mobileStr) && !TextUtils.isEmpty(addressStr) && radioGroup.getCheckedRadioButtonId()!=-1){
                    String name = nameStr;
                    int height = Integer.parseInt(heightStr);
                    int weight = Integer.parseInt(weightStr);
                    int age = Integer.parseInt(ageStr);
                    double mobile = Double.parseDouble(mobileStr);
                    String address = addressStr;
                    selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
                    String gender = selectedGender.getText().toString();

                    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                    DatabaseReference reference = rootNode.getReference("User");
                    dbUser addUser = new dbUser(name, height, age, weight, gender, mobile ,address);
                    reference.child(user.getUid()).setValue(addUser);
                    Toast.makeText(update_profile.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                    finish();

                }else {
                    Toast.makeText(update_profile.this, "Please Fill All The Details", Toast.LENGTH_SHORT).show();
                }
                //Closing Activity After Successful Update
            }
        });


        updateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Get the selected image URI
            Uri selectedImageUri = data.getData();
            avatarImageView.setImageURI(selectedImageUri);

            // Do something with the selected image
            // ...
        }
    }

    // ...
}