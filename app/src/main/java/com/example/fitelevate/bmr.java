package com.example.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class bmr extends AppCompatActivity {
    float bmr=0f;
    EditText bmr_height;
    EditText bmr_weight;
    EditText bmr_age;


    RadioButton maleRadioButton,femaleRadioButton;
    boolean maleChecked = false;
    boolean femaleChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        bmr_height=findViewById(R.id.bmr_heightIn);
        bmr_weight=findViewById(R.id.weight_in);
        bmr_age=findViewById(R.id.age_input);
        maleRadioButton=findViewById(R.id.male_radio_btn);
        femaleRadioButton=findViewById(R.id.female_radio_btn);
        Button submitButton = findViewById(R.id.bmr_submit_btn);
        submitButton.setOnClickListener(view -> {
            String weightStr = bmr_weight.getText().toString();
            String heightStr = bmr_height.getText().toString();
            String ageStr = bmr_age.getText().toString();
            if (!TextUtils.isEmpty(weightStr) && !TextUtils.isEmpty(heightStr) && !TextUtils.isEmpty(ageStr)) {
                float weight = Float.parseFloat(weightStr);
                float height = Float.parseFloat(heightStr);
                float age = Float.parseFloat(ageStr);
                if (maleChecked) {
                    // Perform male BMR calculation
                    bmr = 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
                } else if (femaleChecked) {
                    // Perform female BMR calculation
                    bmr = 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
                }
                Intent intent = new Intent(getApplicationContext(), bmr_result.class);
                intent.putExtra("bmr_value", bmr);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.male_radio_btn:
                if (checked) {
                    maleChecked = true;
                    femaleChecked = false;
                    bmr_height.setText("");
                    bmr_weight.setText("");
                    bmr_age.setText("");
                }
                break;
            case R.id.female_radio_btn:
                if (checked) {
                    maleChecked = false;
                    femaleChecked = true;
                    bmr_height.setText("");
                    bmr_weight.setText("");
                    bmr_age.setText("");
                }
                break;
        }
    }
}

