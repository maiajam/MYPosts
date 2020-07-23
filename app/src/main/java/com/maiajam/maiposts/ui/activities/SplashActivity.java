package com.maiajam.maiposts.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.maiajam.maiposts.R;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startAfter2Sec();
    }

    private void startAfter2Sec() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2*1000);
                    goAllPostActivity();
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       thread.start();
    }

    private void goAllPostActivity() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
}
