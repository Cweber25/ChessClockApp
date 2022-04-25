package com.example.chessclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countdownText;
    private TextView whiteScore;
    private TextView blackScore;

    private Button countdownButton;
    private Button countdownButton2;
    private Button whiteWin;
    private Button blackWin;
    private Button draw;



    private CountDownTimer countDownTimer;
    private CountDownTimer countDownTimer2;
    private long timeLeftInMillieseconds; //10 mins
    private long timeLeftInMillieseconds2; //10 mins
    private boolean timerRunning;
    private boolean timer2Running = false;
    private double whiteCounter;
    private double blackCounter;
    private int count = 0;
    private long newTime;
    private int i = 0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownText = findViewById(R.id.countdown_text);
        countdownButton =  findViewById(R.id.countdown_button);
        countdownButton2 = findViewById(R.id.countdown_button2);
        whiteWin = findViewById(R.id.whiteWin);
        blackWin = findViewById(R.id.blackWin);
        draw = findViewById(R.id.draw);
        whiteScore = findViewById(R.id.scoreWhite);
        blackScore = findViewById(R.id.scoreBlack);
        String u_value=getIntent().getStringExtra("ct");


        if(timeLeftInMillieseconds != 0) {
            int a = Integer.parseInt(u_value);
            timeLeftInMillieseconds = a;
            timeLeftInMillieseconds2 = a;

        } else {
            timeLeftInMillieseconds = 600000; //10 mins
            timeLeftInMillieseconds2 = 600000; //10 mins
        }



        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startStop();
            }
        });

        countdownButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (timerRunning) {

                    } else {
                        startTimer();
                        stopTimer2();
                    }
                }

        });

        whiteWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                whiteCounter++;
                whiteScore.setText(whiteCounter + "");
            }
        });

        blackWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blackCounter++;
                blackScore.setText(blackCounter +"");
            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whiteCounter += 0.5;
                blackCounter += 0.5;
                whiteScore.setText(whiteCounter + "");
                blackScore.setText(blackCounter +"");
            }
        });

        updateTimer1();
        updateTimer2();
    }



    public void startStop() {
        if (timer2Running) {

        } else {
            i++;
            if (timerRunning) {
                stopTimer();
            } else {
                startTimer();
            }
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

        //countdownButton.setText("Pause");
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
        }.start();

        timer2Running = true;

    }

    public void stopTimer2() {
        countDownTimer2.cancel();
        timer2Running = false;
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


    public void settingScreen(View view) {
        Intent myIntent = new Intent(MainActivity.this, settings.class);
        startActivity(myIntent);
    }

    public void reset(View view) {
        whiteScore.setText(0 + "");
        blackScore.setText(0 +"");
        //countdownButton;
    }
}