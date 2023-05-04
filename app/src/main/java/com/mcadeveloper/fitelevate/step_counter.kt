package com.mcadeveloper.fitelevate

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class step_counter : AppCompatActivity(), SensorEventListener {

    private var sensorManager: SensorManager? = null

    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    private var cal = 0
    private var feet = 0
    private var distance = 0

    private lateinit var tv_stepsTaken: TextView
    private lateinit var textViewCaloriesBurnt: TextView
    private lateinit var textViewDistance: TextView
    private lateinit var progress_circular: CircularProgressBar

    var user = FirebaseAuth.getInstance().currentUser
    var uid = user!!.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_counter)

        tv_stepsTaken = findViewById<TextView>(R.id.tv_stepsTaken)
        textViewCaloriesBurnt = findViewById<TextView>(R.id.textViewCaloriesBurnt)
        textViewDistance = findViewById<TextView>(R.id.textViewDistance)
        progress_circular = findViewById<CircularProgressBar>(R.id.progress_circular)

        loaddata()
        resetSteps()

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        running = true
        val stepSensor:Sensor? = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if(stepSensor==null){
            Toast.makeText(this, "No sensor detected on this device", Toast.LENGTH_SHORT).show()
        }
        else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if(running){
            totalSteps = p0!!.values[0]
            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            tv_stepsTaken.text=("$currentSteps")

            val cal = (currentSteps*0.045).toInt()
            textViewCaloriesBurnt.text = cal.toString()
            val feet = (currentSteps*2.5).toInt()
            val distance = (feet/3.281).toInt()
            textViewDistance.text = distance.toString()

            progress_circular.apply{
                setProgressWithAnimation(currentSteps.toFloat())
            }
        }
    }

    private fun resetSteps(){

        tv_stepsTaken.setOnClickListener(){
            Toast.makeText(this, "Long Tap To Reset", Toast.LENGTH_SHORT).show()
        }
        tv_stepsTaken.setOnLongClickListener{
            //Start Saving Values Before Resetting
            val s=tv_stepsTaken.text.toString();
            val c=textViewCaloriesBurnt.text.toString();
            val d=textViewDistance.text.toString();
            //End
            previousTotalSteps = totalSteps
            tv_stepsTaken.text=0.toString()
            textViewCaloriesBurnt.text=0.toString()
            textViewDistance.text=0.toString()
            progress_circular.apply{
                progress=0f
            }

            //Start Saving Data In Firebase
            if (s.toInt() != 0 && c.toInt() != 0 && d.toInt() != 0) {
                val rootNode = FirebaseDatabase.getInstance()
                val reference = rootNode.getReference("Steps")
                val addSteps = dbSteps(s.toInt(), c.toInt(), d.toInt())
                reference.child(user!!.uid).setValue(addSteps)
            }
            //End

            Toast.makeText(this, s+", "+c+", "+d, Toast.LENGTH_SHORT).show()
            savedata()
            true
        }
    }

    private fun savedata(){
        val sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1",previousTotalSteps)
        editor.apply()
    }

    private fun loaddata(){
        val sharedPreferences = getSharedPreferences("myPrefs",Context.MODE_PRIVATE)
        val savedNumber = sharedPreferences.getFloat("key1", 0f)
        Log.d("MainActivity", "$savedNumber")
        previousTotalSteps = savedNumber
    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}