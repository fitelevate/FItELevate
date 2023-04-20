package com.knit.fitelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class weightLoose extends AppCompatActivity {


    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_loose);

        Toolbar toolbar= findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
        newArray=new int[]{
                //sabhi exercise ki id find karni hai according to their respective xml
          R.id.jumpingJacks,R.id.squatKicks,R.id.pushups,R.id.reverseCrunches,R.id.squatReachUps,R.id.inchWarms,R.id.frogPress,R.id.lunges,R.id.squats,R.id.legRaises,
        };
    }
    public void Imagebuttonclicked(View view) {
        for (int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("First",String.valueOf(value));
                Intent intent=new Intent(weightLoose.this, ActivityWeightLooseExercise.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }

    }
}