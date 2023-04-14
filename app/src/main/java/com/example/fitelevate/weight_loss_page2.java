package com.example.fitelevate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class weight_loss_page2 extends AppCompatActivity {
    Button button_page3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss_page2);
        button_page3 = findViewById(R.id.btn_page3);
        button_page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weight_loss_page3 = new Intent(weight_loss_page2.this, com.example.fitelevate.weight_loss_page3.class);
                startActivity(weight_loss_page3);
            }
        });
    }
}