package com.developer.fitelevate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class muscle_gain_page1 extends AppCompatActivity {
    Button gain_btn_page1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_gain_page1);
        gain_btn_page1 = findViewById(R.id.gain_page1);
        gain_btn_page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gain_page2 = new Intent(muscle_gain_page1.this, muscle_gain_page2.class);
                startActivity(gain_page2);
            }
        });
    }
}