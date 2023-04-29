package com.developer.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nutrition extends AppCompatActivity {

    Button weight_loss, muscle_building;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        weight_loss = findViewById(R.id.weight_loss_btn);
        muscle_building = findViewById(R.id.wight_gain_btn);

        weight_loss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weight_loss_diet_page = new Intent(nutrition.this, weight_loss_page1.class);
                startActivity(weight_loss_diet_page);
            }
        });
        muscle_building.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent muscle_gain_diet_page = new Intent(nutrition.this, muscle_gain_page1.class);
                startActivity(muscle_gain_diet_page);
            }
        });

    }
}