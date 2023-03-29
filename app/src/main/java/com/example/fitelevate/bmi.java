package com.example.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class bmi extends AppCompatActivity {

    ImageView bmi_banner;
    EditText bmi_weight_input, bmi_height_input;
    Button calculate_bmi_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        bmi_banner = findViewById(R.id.bmi_banner);
        bmi_weight_input = findViewById(R.id.bmi_weight_input);
        bmi_height_input = findViewById(R.id.bmi_height_input);
        calculate_bmi_button = findViewById(R.id.calculate_bmi_button);

        calculate_bmi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float user_height = Float.parseFloat(String.valueOf(bmi_height_input.getText()))/100;
                float user_weight = Float.parseFloat(String.valueOf(bmi_weight_input.getText()));
                float bmi = user_weight / (user_height * user_height);
                Intent i = new Intent(getApplicationContext(), bmi_result.class);
                i.putExtra("bmi_result", bmi);
                startActivity(i);
            }
        });

    }
}