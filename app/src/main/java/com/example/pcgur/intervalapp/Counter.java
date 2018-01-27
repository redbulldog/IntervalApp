package com.example.pcgur.intervalapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Counter extends AppCompatActivity {
    @BindView(R.id.szamlalo) TextView szamlalo;
    Integer korok, breaks, interval_seconds, interval_minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        sharedToVariable();
        new CountDownTimer(interval_minutes*60000+interval_seconds*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                szamlalo.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                szamlalo.setText("done!");
            }
        }.start();
    }
    public void sharedToVariable(){
        SharedPreferences sharedPreferences = getSharedPreferences("Interval", Context.MODE_PRIVATE);
        this.korok = sharedPreferences.getInt("korok", 0);
        this.breaks = sharedPreferences.getInt("breaks", 0);
        this.interval_seconds = sharedPreferences.getInt("interval_seconds", 0);
        this.interval_minutes = sharedPreferences.getInt("interval_minutes", 0);
    }
}
