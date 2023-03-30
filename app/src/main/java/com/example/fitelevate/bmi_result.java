package com.example.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class bmi_result extends AppCompatActivity {
    TextView result_text, result_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        result_text = findViewById(R.id.result_text);
        result_number = findViewById(R.id.result_number);

        Intent i = getIntent();
        float new_bmi = i.getFloatExtra("bmi_result", 0);
        result_number.setText(String.valueOf(new_bmi));

    }
}