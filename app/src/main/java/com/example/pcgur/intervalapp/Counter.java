package com.example.pcgur.intervalapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Counter extends AppCompatActivity {
    @BindView(R.id.szamlalo) TextView szamlalo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                szamlalo.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                szamlalo.setText("done!");
            }
        }.start();
    }
}
