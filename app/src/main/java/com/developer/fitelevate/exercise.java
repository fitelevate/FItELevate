package com.developer.fitelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exercise extends AppCompatActivity {
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar=findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
        button1= findViewById(R.id.weightLooseButton);
        button2=findViewById(R.id.weightGainButton);
        button1.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),weightLoose.class);
            startActivity(intent);
        });


        button2.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), muscleGain.class);
            startActivity(intent);
        });

    }

    public void weightGain(View view) {
        Intent intent=new Intent(getApplicationContext(), muscleGain.class);
        startActivity(intent);
    }

    public void weightLoose(View view) {
        Intent intent=new Intent(getApplicationContext(),weightLoose.class);
        startActivity(intent);
    }
}