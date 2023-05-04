package com.mcadeveloper.fitelevate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class weight_loss_page1 extends AppCompatActivity {
    Button button_page2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loss_page1);
        button_page2 = findViewById(R.id.btn_page2);

        button_page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weight_loss_page2 = new Intent(weight_loss_page1.this, com.mcadeveloper.fitelevate.weight_loss_page2.class);
                startActivity(weight_loss_page2);
            }
        });
    }
}