package com.example.chessclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countdownText;
    private Button countdownButton;
    private Button countdownButton2;

    private CountDownTimer countDownTimer;
    private CountDownTimer countDownTimer2;
    private long timeLeftInMillieseconds = 600000; //10 mins
    private long timeLeftInMillieseconds2 = 600000; //10 mins
    private boolean timerRunning;
    private boolean timer2Running = true;

    private int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownText = findViewById(R.id.countdown_text);
        countdownButton =  findViewById(R.id.countdown_button);
        countdownButton2 = findViewById(R.id.countdown_button2);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startStop();
            }
        });

        countdownButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerRunning) {

                } else {
                    startTimer();
                    stopTimer2();
                }
            }
        });

        updateTimer1();
        updateTimer2();
    }
    public void startStop() {
        if(timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
        }

    public void startStop2() {
        if(timer2Running) {
            stopTimer2();
        } else {
            startTimer2();
        }
    }



        public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillieseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillieseconds = l;
                updateTimer1();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        countdownButton.setText("Pause");
        timerRunning = true;

        }

        public void stopTimer() {
            countDownTimer.cancel();
            //countdownButton.setText("Start");
            timerRunning = false;
            startTimer2();
        }

    public void startTimer2() {
        countDownTimer2 = new CountDownTimer(timeLeftInMillieseconds2, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillieseconds2 = l;
                updateTimer2();
            }

            @Override
            public void onFinish() {

            }
        }.start();}

    public void stopTimer2() {
        countDownTimer2.cancel();
        //countdownButton.setText("Start");

    }

        public void updateTimer1() {
        int minutes = (int) timeLeftInMillieseconds / 60000;
        int seconds = (int) timeLeftInMillieseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10 ) timeLeftText += "0";
        timeLeftText += seconds;

        countdownButton.setText(timeLeftText);
        }

    public void updateTimer2() {
        int minutes = (int) timeLeftInMillieseconds2 / 60000;
        int seconds = (int) timeLeftInMillieseconds2 % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10 ) timeLeftText += "0";
        timeLeftText += seconds;

        countdownButton2.setText(timeLeftText);
    }


}