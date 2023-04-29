package com.developer.fitelevate;

        import static com.developer.fitelevate.R.*;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.widget.Button;
        import android.widget.TextView;

public class ActivityBreathingYoga extends AppCompatActivity {
    String buttonValue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftInMilisecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");
        int intvalue = Integer.valueOf(buttonValue);

        switch (intvalue) {
            // Use all values here
            case 1:
                setContentView(layout.pursed_lip_breathing);
                break;

            case 2:
                setContentView(layout.diaphragmatic_breathing);
                break;

            case 3:
                setContentView(layout.breath_focus_technique);
                break;
            case 4:
                setContentView(layout.lions_breath);
                break;
            case 5:
                setContentView(layout.alternate_nostril_breath);
                break;

            case 6:
                setContentView(layout.equal_brething);
                break;

            case 7:
                setContentView(layout.resonant_breathing);
                break;

            case 8:
                setContentView(layout.sitali_breath);
                break;

            case 9:
                setContentView(layout.deep_breathing);
                break;

            case 10:
                setContentView(layout.bhramari);
                break;




            // Add more cases as needed

            default:
                setContentView(layout.activity_breathing);
                break;
        }


        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.timer);
        startBtn.setOnClickListener(view -> {
            if (MTimeRunning) {
                stoptimer();
            } else {
                startTimer();
            }
        });
        startTimer();
    }

    private void stoptimer(){
        countDownTimer.cancel();
        MTimeRunning=false;
        startBtn.setText("START");
    }
    private void startTimer(){
        final CharSequence value1=mtextview.getText();
        String num1=value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);
        final int number=Integer.valueOf(num2)*60+ Integer.valueOf(num3);
        MTimeLeftInMilisecond=number*1000;

        countDownTimer=new CountDownTimer(MTimeLeftInMilisecond,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                MTimeLeftInMilisecond=millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue=Integer.valueOf(buttonValue)+1;
                if (newvalue<=7){
                    Intent intent=new Intent(ActivityBreathingYoga.this,ActivityBreathingYoga.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf( newvalue));
                    startActivity(intent);
                }
                else {
                    newvalue=1;
                    Intent intent =new Intent(ActivityBreathingYoga.this,ActivityBreathingYoga.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }


            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunning=true;

    }
    private void updateTimer() {
        int minutes = (int) MTimeLeftInMilisecond / 60000;
        int seconds = (int) (MTimeLeftInMilisecond % 60000) / 1000; // Corrected calculation
        String timeLeftText = "";
        if (minutes < 10)
            timeLeftText = "0" + minutes; // Corrected line
        else
            timeLeftText = String.valueOf(minutes);
        if (seconds < 10)
            timeLeftText += ":0" + seconds; // Corrected line
        else
            timeLeftText += ":" + String.valueOf(seconds);
        mtextview.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stoptimer();
    }
}