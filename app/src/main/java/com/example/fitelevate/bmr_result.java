package com.example.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class bmr_result extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bmr_result);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_result);

        // Get the BMR value from the Intent extra
        float bmr = getIntent().getFloatExtra("bmr_value", 0f);

        // Display the BMR value in the TextView
        TextView bmrTextView = findViewById(R.id.bmr_result_text);
        bmrTextView.setText(String.format(Locale.getDefault(), "%.2f", bmr));
    }
}