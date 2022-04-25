package com.example.chessclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class settings extends AppCompatActivity {
    private Button timeV1;
    private Button timeV2;
    private Button timeV3;
    private Button timeV5;
    private Button timeV10;
    private Button timeV30;
    private Button addTime;

    private EditText customT;
    private EditText customIncrement;

    public TextView currentT;

    public long timePH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        timeV1 = findViewById(R.id.time1);
        timeV2 = findViewById(R.id.time2);
        timeV3 = findViewById(R.id.time3);
        timeV5 = findViewById(R.id.time5);
        timeV10 = findViewById(R.id.time10);
        timeV30 = findViewById(R.id.time30);
        addTime = findViewById(R.id.addTime);

        currentT = findViewById(R.id.currentTime);
        customIncrement = findViewById(R.id.customInc);
        customT = findViewById(R.id.customTime);

        timeV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = timeV1.getText().toString();
                //timePH = 6000;
                changeTime(ph);
            }
        });

        timeV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = timeV2.getText().toString();
                //timePH = 12000;
                changeTime(ph);
            }
        });

        timeV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = timeV3.getText().toString();
                //timePH = 18000;
                changeTime(ph);
            }
        });

        timeV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = timeV10.getText().toString();
                //timePH = 30000;
                changeTime(ph);
            }
        });

        timeV10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = timeV10.getText().toString();
                //timePH = 60000;
                changeTime(ph);

            }
        });

        timeV30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = timeV30.getText().toString();
                //timePH = 180000;
                changeTime(ph);

            }
        });

        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = customT.getText().toString();
                changeTime(ph);
            }
        });


    }

    public void returnToMain(View view) {

        Intent myIntent = new Intent(settings.this, MainActivity.class);
        myIntent.putExtra("ct", timePH);
        startActivity(myIntent);
        finish();
    }



    public void changeTime(String a){
        String aHelp = a;
        int n = Integer.parseInt(a);
        timePH = n * 6000;
        currentT.setText(aHelp + " " + timePH);
    }
}