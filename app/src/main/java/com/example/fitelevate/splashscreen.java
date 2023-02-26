package com.example.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splashscreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Intent iHome=new Intent(splashscreen.this,login.class);
        new Handler().postDelayed(() -> {

            startActivity(iHome);
            finish();
        },3000);


    }
}