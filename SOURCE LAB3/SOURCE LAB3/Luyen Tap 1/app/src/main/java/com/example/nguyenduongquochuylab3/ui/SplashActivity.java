package com.example.nguyenduongquochuylab3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nguyenduongquochuylab3.R;

public class SplashActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() ->
                startActivity(new Intent(this, MainActivity.class)), 1200);
    }
    @Override protected void onPause() { super.onPause(); finish(); }
}
