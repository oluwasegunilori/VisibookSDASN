package com.example.visibooksdasna;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.silvestrpredko.dotprogressbar.DotProgressBar;

public class MainActivity extends AppCompatActivity {
    DotProgressBar progressBar;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.dot_progress_bar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            scheduleNotifications();
            startActivity(new Intent(MainActivity.this, Home.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_oute);
            }

        }, SPLASH_TIME_OUT);



    }

    private void scheduleNotifications() {





    }

}
