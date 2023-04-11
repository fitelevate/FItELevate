package com.example.fitelevate

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.fitelevate.databinding.ActivityWaterBinding
import com.google.android.material.snackbar.Snackbar
import utils.AppUtils
//import kotlinx.android.synthetic.main.activity_water.*
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

class WaterActivity : AppCompatActivity() {

private var weight: String = ""
private var workTime: String = ""
private var wakeupTime: Long = 0
private var sleepingTime: Long = 0
private lateinit var sharedPref: SharedPreferences
private var doubleBackToExitPressedOnce = false
        private lateinit var binding: ActivityWaterBinding
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityWaterBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)
        val is24h = android.text.format.DateFormat.is24HourFormat(this.applicationContext)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        //setContentView(R.layout.activity_water)

        sharedPref = getSharedPreferences(AppUtils.USERS_SHARED_PREF, MODE_PRIVATE)

        wakeupTime = sharedPref.getLong(AppUtils.WAKEUP_TIME, 1558323000000)
        sleepingTime = sharedPref.getLong(AppUtils.SLEEPING_TIME_KEY, 1558369800000)

        binding.etWakeUpTime.editText!!.setOnClickListener {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = wakeupTime

        val mTimePicker: TimePickerDialog
        mTimePicker = TimePickerDialog(
        this,
        TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->

        val time = Calendar.getInstance()
        time.set(Calendar.HOUR_OF_DAY, selectedHour)
        time.set(Calendar.MINUTE, selectedMinute)
        wakeupTime = time.timeInMillis

        binding.etWakeUpTime.editText!!.setText(
        String.format("%02d:%02d", selectedHour, selectedMinute)
        )
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), is24h
        )
        mTimePicker.setTitle("Select Wakeup Time")
        mTimePicker.show()
        }


        binding.etSleepTime.editText!!.setOnClickListener {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = sleepingTime

        val mTimePicker: TimePickerDialog
        mTimePicker = TimePickerDialog(
        this,
        TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->

        val time = Calendar.getInstance()
        time.set(Calendar.HOUR_OF_DAY, selectedHour)
        time.set(Calendar.MINUTE, selectedMinute)
        sleepingTime = time.timeInMillis

        binding.etSleepTime.editText!!.setText(
        String.format("%02d:%02d", selectedHour, selectedMinute)
        )
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), is24h
        )
        mTimePicker.setTitle("Select Sleeping Time")
        mTimePicker.show()
        }

        binding.btnContinue.setOnClickListener {

        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.initUserInfoParentLayout.windowToken, 0)

        weight = binding.etWeight.editText!!.text.toString()
        workTime = binding.etWorkTime.editText!!.text.toString()

        when {
        TextUtils.isEmpty(weight) -> Snackbar.make(it, "Please input your weight", Snackbar.LENGTH_SHORT).show()
        weight.toInt() > 200 || weight.toInt() < 20 -> Snackbar.make(
        it,
        "Please input a valid weight",
        Snackbar.LENGTH_SHORT
        ).show()
        TextUtils.isEmpty(workTime) -> Snackbar.make(
        it,
        "Please input your workout time",
        Snackbar.LENGTH_SHORT
        ).show()
        workTime.toInt() > 500 || workTime.toInt() < 0 -> Snackbar.make(
        it,
        "Please input a valid workout time",
        Snackbar.LENGTH_SHORT
        ).show()
        else -> {

        val editor = sharedPref.edit()
        editor.putInt(AppUtils.WEIGHT_KEY, weight.toInt())
        editor.putInt(AppUtils.WORK_TIME_KEY, workTime.toInt())
        editor.putLong(AppUtils.WAKEUP_TIME, wakeupTime)
        editor.putLong(AppUtils.SLEEPING_TIME_KEY, sleepingTime)
        editor.putBoolean(AppUtils.FIRST_RUN_KEY, false)

        val totalIntake = AppUtils.calculateIntake(weight.toInt(), workTime.toInt())
        val df = DecimalFormat("#")
        df.roundingMode = RoundingMode.CEILING
        editor.putInt(AppUtils.TOTAL_INTAKE, df.format(totalIntake).toInt())

        editor.apply()
        startActivity(Intent(this, WaterMainActivity::class.java))
        finish()

        }
        }
        }

        }

        override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
        super.onBackPressed()
        return
        }

        this.doubleBackToExitPressedOnce = true
        Snackbar.make(
        this.window.decorView.findViewById(android.R.id.content),
        "Please click BACK again to exit",
        Snackbar.LENGTH_SHORT
        ).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1000)
        }
        }
