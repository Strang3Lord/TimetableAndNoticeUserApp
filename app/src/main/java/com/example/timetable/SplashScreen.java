package com.example.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    public static int SPLASH_TIME_OUT=1000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable(){
                @Override
public void run(){
            Intent splashIntent =new Intent(SplashScreen.this,MainActivity.class);
startActivity(splashIntent);
        finish();
    }
    },SPLASH_TIME_OUT);
}
}