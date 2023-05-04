package com.mcadeveloper.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class bmi_result extends AppCompatActivity {
    TextView result_text, result_number, textViewCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        result_text = findViewById(R.id.result_text);
        result_number = findViewById(R.id.result_number);
        textViewCategory = findViewById(R.id.textViewCategory);

        Intent i = getIntent();
        float new_bmi = i.getFloatExtra("bmi_result", 0);
        result_number.setText(String.valueOf(new_bmi));
        if(new_bmi<18.5)
            textViewCategory.setText("Underweight");
        else if(new_bmi>=18.5 && new_bmi<=24.9)
            textViewCategory.setText("Normal Weight");
        else if(new_bmi>=25 && new_bmi<=29.9)
            textViewCategory.setText("Overweight");
        else if(new_bmi>=30 && new_bmi<=34.9)
            textViewCategory.setText("Obesity");
        else if(new_bmi>=35)
            textViewCategory.setText("Extreme Obesity");
    }
}