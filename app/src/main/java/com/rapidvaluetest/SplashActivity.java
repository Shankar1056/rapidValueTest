package com.rapidvaluetest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rapidvaluetest.imagelist.ImageListActivity;
import com.rapidvaluetest.user.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    public static final String LOGINSTATUS = "login_status";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        goToNextActivity();
    }

    private void goToNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SharedPrefernce.getBoolPreferences(LOGINSTATUS)){
                    startActivity(new Intent(SplashActivity.this, ImageListActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        }, 2000);
    }
}
