package com.mobimp.econstruction;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    private MyCounter mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mCounter = new MyCounter(3000, 3000);
        mCounter.start();
    }

    private class MyCounter extends CountDownTimer {

        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            Intent myIntent = new Intent(Splash.this,LoginActivity.class);
            startActivity(myIntent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

        }

    }
}
