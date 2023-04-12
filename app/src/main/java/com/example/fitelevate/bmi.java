package com.example.fitelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class bmi extends AppCompatActivity {

    ImageView bmi_banner;
    EditText bmi_weight_input, bmi_height_input;
    Button calculate_bmi_button;

    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
    String u=user.getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        bmi_banner = findViewById(R.id.bmi_banner);
        bmi_weight_input = findViewById(R.id.bmi_weight_input);
        bmi_height_input = findViewById(R.id.bmi_height_input);
        calculate_bmi_button = findViewById(R.id.calculate_bmi_button);

        //fetch height and weight values
        Query checkUser = FirebaseDatabase.getInstance().getReference("User").orderByKey().equalTo(u);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String height = snapshot.child(u).child("height").getValue().toString();
                    String weight = snapshot.child(u).child("weight").getValue().toString();
                    bmi_height_input.setText(height);
                    bmi_weight_input.setText(weight);
                }
                else{
                    //Toast.makeText(bmi.this, "User Details Does Not Exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(bmi.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        calculate_bmi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightStr = bmi_height_input.getText().toString();
                String weightStr = bmi_weight_input.getText().toString();
                if(!TextUtils.isEmpty(heightStr) && !TextUtils.isEmpty(weightStr)){
                    float user_height = Float.parseFloat(heightStr)/100;
                    float user_weight = Float.parseFloat(weightStr);
                    float bmi = user_weight / (user_height * user_height);
                    //formatting bmi up-to one decimal place
                    String formattedBmi = String.format("%.1f", bmi);
                    //again converting it into float
                    bmi = Float.parseFloat(formattedBmi);

                    //Start Writing in database
                    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                    DatabaseReference reference = rootNode.getReference("bmi");
                    dbBmi addBmi = new dbBmi(bmi);
                    reference.child(user.getUid()).setValue(addBmi);
                    //End Writing in Database

                    Intent i = new Intent(bmi.this, bmi_result.class);
                    i.putExtra("bmi_result", bmi);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}