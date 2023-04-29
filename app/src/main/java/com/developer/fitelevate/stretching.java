package com.developer.fitelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class stretching extends AppCompatActivity {
    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching);
        Toolbar toolbar=findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);
        newArray=new int[]{
                //sabhi exercise ki id find karni hai according to their respective xml
                R.id.ssbend,R.id.ccpose,R.id.childpose,R.id.wthedog,R.id.cobstretch,R.id.dntochest,R.id.fwbend,R.id.chair,R.id.shstretch,R.id.kneetochest,
        };
    }

    public void imgbtnclicked(View view) {
        for (int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("First",String.valueOf(value));
                Intent intent=new Intent(stretching.this, ActivityStretchingYoga.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }

    }
}



