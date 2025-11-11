package com.example.nguyenduongquochuylab3;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button bAlpha, bScale, bTrans, bRotate;

    ObjectAnimator alphaAnim, scaleAnim, transAnim, rotateAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgFace);
        bAlpha = findViewById(R.id.btnAlpha);
        bScale = findViewById(R.id.btnScale);
        bTrans = findViewById(R.id.btnTrans);
        bRotate = findViewById(R.id.btnRotate);

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

        bAlpha.setOnClickListener(v -> toggle(alphaAnim));
        bScale.setOnClickListener(v -> toggle(scaleAnim));
        bTrans.setOnClickListener(v -> toggle(transAnim));
        bRotate.setOnClickListener(v -> toggle(rotateAnim));
    }

    private void toggle(ObjectAnimator a) {
        if (a.isRunning()) a.cancel(); else a.start();
    }
}
