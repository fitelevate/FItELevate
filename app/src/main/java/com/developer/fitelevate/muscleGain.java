package com.developer.fitelevate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.Toolbar;


public class muscleGain extends AppCompatActivity {

    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_gain);
        Toolbar toolbar=findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
        newArray=new int[]{
                //sabhi exercise ki id find karni hai according to their respective xml
                R.id.pose1,R.id.pose2,R.id.pose3,R.id.pose4,R.id.pose5,R.id.pose6,R.id.pose7,R.id.pose8,R.id.pose9,R.id.pose10,
        };

    }



    public void Imagebuttonpressed(View view) {
        for (int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("First",String.valueOf(value));
                Intent intent=new Intent(muscleGain.this, ActivityMuscleGainExercise.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }

    }
}