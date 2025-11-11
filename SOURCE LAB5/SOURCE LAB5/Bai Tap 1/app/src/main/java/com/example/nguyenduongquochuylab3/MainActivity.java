package com.example.nguyenduongquochuylab3;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ObjectAnimator alphaAnim, scaleAnim, transAnim, rotateAnim;
    final Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgFace);

        alphaAnim = ObjectAnimator.ofFloat(img, View.ALPHA, 1f, 0.3f, 1f);
        alphaAnim.setDuration(900);
        alphaAnim.setRepeatCount(ValueAnimator.INFINITE);

        PropertyValuesHolder sx = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 1.25f, 1f);
        PropertyValuesHolder sy = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 1.25f, 1f);
        scaleAnim = ObjectAnimator.ofPropertyValuesHolder(img, sx, sy);
        scaleAnim.setDuration(900);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);

        transAnim = ObjectAnimator.ofFloat(img, View.TRANSLATION_X, 0f, 60f, -60f, 0f);
        transAnim.setDuration(1200);
        transAnim.setRepeatCount(ValueAnimator.INFINITE);

        rotateAnim = ObjectAnimator.ofFloat(img, View.ROTATION, 0f, 360f);
        rotateAnim.setDuration(1200);
        rotateAnim.setRepeatCount(ValueAnimator.INFINITE);

        img.setOnClickListener(v -> playRandom());
    }

    private void stopAll() {
        if (alphaAnim.isRunning()) alphaAnim.cancel();
        if (scaleAnim.isRunning()) scaleAnim.cancel();
        if (transAnim.isRunning()) transAnim.cancel();
        if (rotateAnim.isRunning()) rotateAnim.cancel();
    }

    private void playRandom() {
        stopAll();
        int which = rnd.nextInt(4);
        switch (which) {
            case 0: alphaAnim.start(); break;
            case 1: scaleAnim.start(); break;
            case 2: transAnim.start(); break;
            default: rotateAnim.start(); break;
        }
    }
}
