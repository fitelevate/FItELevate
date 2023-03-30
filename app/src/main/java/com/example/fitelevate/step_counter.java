package com.example.fitelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class step_counter extends AppCompatActivity implements SensorEventListener {
    private TextView textViewStepCounter, textViewCaloriesBurnt, textViewDistance;
    private SensorManager sensorManager;
    private Sensor mStepCounter;
    private boolean isCounterSensorPresent;
    int stepCount=0,cal=0,feet=0,distance=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepCounter = findViewById(R.id.textViewStepCounter);
        textViewCaloriesBurnt = findViewById(R.id.textViewCaloriesBurnt);
        textViewDistance = findViewById(R.id.textViewDistance);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            mStepCounter = sensorManager.getDefaultSensor((Sensor.TYPE_STEP_COUNTER));
            isCounterSensorPresent = true;
        }
        else {
            textViewStepCounter.setText("Counter Sensor Is Not Present");
            isCounterSensorPresent = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepCounter){
            stepCount = (int) sensorEvent.values[0];
            textViewStepCounter.setText(String.valueOf(stepCount));
            cal = (int) ((int) stepCount*0.045);
            textViewCaloriesBurnt.setText(String.valueOf(cal));
            feet = (int) (stepCount*2.5);
            distance = (int) (feet/3.281);
            textViewDistance.setText(String.valueOf(distance)+" meters");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
            sensorManager.unregisterListener(this, mStepCounter);
    }
}