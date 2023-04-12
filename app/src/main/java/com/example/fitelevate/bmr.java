package com.example.fitelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class bmr extends AppCompatActivity {
    float bmr=0f;
    EditText bmr_height;
    EditText bmr_weight;
    EditText bmr_age;
    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    String uid=user.getUid();
    RadioGroup radioGroup;
    RadioButton selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        bmr_height=findViewById(R.id.bmr_heightIn);
        bmr_weight=findViewById(R.id.weight_in);
        bmr_age=findViewById(R.id.age_input);
        radioGroup=findViewById(R.id.radiogroup);
        Button submitButton = findViewById(R.id.bmr_submit_btn);

        //fetch height, weight, and gender values
        Query checkUser = FirebaseDatabase.getInstance().getReference("User").orderByKey().equalTo(uid);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String height = snapshot.child(uid).child("height").getValue().toString();
                    String weight = snapshot.child(uid).child("weight").getValue().toString();
                    String age = snapshot.child(uid).child("age").getValue().toString();
                    String gender = snapshot.child(uid).child("gender").getValue().toString();
                    bmr_height.setText(height);
                    bmr_weight.setText(weight);
                    bmr_age.setText(age);
                    if(gender.equals("Male")){
                        radioGroup.check(R.id.male_radio_btn);
                    }
                    else {
                        radioGroup.check(R.id.female_radio_btn);
                    }
                }
                else {
                    //Toast.makeText(bmr.this, "User Details Does Not Exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(bmr.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        submitButton.setOnClickListener(view -> {
            String weightStr = bmr_weight.getText().toString();
            String heightStr = bmr_height.getText().toString();
            String ageStr = bmr_age.getText().toString();
            if (!TextUtils.isEmpty(weightStr) && !TextUtils.isEmpty(heightStr) && !TextUtils.isEmpty(ageStr) && radioGroup.getCheckedRadioButtonId()!=-1) {
                float weight = Float.parseFloat(weightStr);
                float height = Float.parseFloat(heightStr);
                float age = Float.parseFloat(ageStr);
                selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
                String gender = selectedGender.getText().toString();
                if (gender.equals("Male")) {
                    // Perform male BMR calculation
                    bmr = 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
                } else {
                    // Perform female BMR calculation
                    bmr = 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
                }

                //formatting bmr up-to one decimal place
                String formattedBmr = String.format("%.0f", bmr);
                //again converting it into float
                bmr = Float.parseFloat(formattedBmr);

                FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                DatabaseReference reference = rootNode.getReference("bmr");
                dbBmr addBmr = new dbBmr(bmr);
                reference.child(user.getUid()).setValue(addBmr);

                Intent intent = new Intent(getApplicationContext(), bmr_result.class);
                intent.putExtra("bmr_value", bmr);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

