package com.example.testproject.presentation.ui.activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testproject.R;
import com.example.testproject.utils.router.RouterImpl;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new RouterImpl(SplashScreenActivity.this).openMainScreen();
                finish();
            }
        }, 2000L);
    }
}
