package com.knit.fitelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class breathing extends AppCompatActivity {
    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing);
        Toolbar toolbar=findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
        newArray=new int[]{
                //sabhi exercise ki id find karni hai according to their respective xml
                R.id.pursed,R.id.diaphragmatic,R.id.breathfocus,R.id.lionsbreath,R.id.alternatenostril,R.id.equalbreath,R.id.resonant,R.id.sitali,R.id.deepbreathing,R.id.bhramiribreath,
        };
    }

    public void onimagebtnclick(View view) {
        for (int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("First",String.valueOf(value));
                Intent intent=new Intent(breathing.this, ActivityBreathingYoga.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }

    }
}