package com.example.fitelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class yoga extends AppCompatActivity {
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        Toolbar toolbar=findViewById(R.id.toolbaar1);
        setSupportActionBar(toolbar);
        button1= findViewById(R.id.stretching_btn);
        button2=findViewById(R.id.breathingbtn);
        button1.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),stretching.class);
            startActivity(intent);
        });


        button2.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), breathing.class);
            startActivity(intent);
        });

    }

    public void breathing(View view) {
        Intent intent=new Intent(getApplicationContext(), breathing.class);
        startActivity(intent);
    }

    public void stretching(View view) {
        Intent intent=new Intent(getApplicationContext(),stretching.class);
        startActivity(intent);
    }
}