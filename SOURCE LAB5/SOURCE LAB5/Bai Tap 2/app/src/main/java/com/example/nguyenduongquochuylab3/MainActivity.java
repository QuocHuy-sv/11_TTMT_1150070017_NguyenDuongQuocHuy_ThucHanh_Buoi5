package com.example.nguyenduongquochuylab3;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    LinearLayout rowMom, rowDad, rowCrush, rowBest;

    ObjectAnimator animMom, animDad, animCrush, animBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitle(getString(R.string.title_quickcall));
        setSupportActionBar(tb);

        rowMom = findViewById(R.id.rowMom);
        rowDad = findViewById(R.id.rowDad);
        rowCrush = findViewById(R.id.rowCrush);
        rowBest = findViewById(R.id.rowBest);

        rowMom.setOnClickListener(v -> dial(getString(R.string.tel_mom)));
        rowDad.setOnClickListener(v -> dial(getString(R.string.tel_dad)));
        rowCrush.setOnClickListener(v -> dial(getString(R.string.tel_crush)));
        rowBest.setOnClickListener(v -> dial(getString(R.string.tel_best)));

        animMom = ObjectAnimator.ofFloat(rowMom, View.ALPHA, 1f, 0.3f, 1f);
        animMom.setDuration(900);
        animMom.setRepeatCount(ValueAnimator.INFINITE);

        PropertyValuesHolder sx = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 1.12f, 1f);
        PropertyValuesHolder sy = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 1.12f, 1f);
        animDad = ObjectAnimator.ofPropertyValuesHolder(rowDad, sx, sy);
        animDad.setDuration(900);
        animDad.setRepeatCount(ValueAnimator.INFINITE);

        animCrush = ObjectAnimator.ofFloat(rowCrush, View.TRANSLATION_X, 0f, 40f, -40f, 0f);
        animCrush.setDuration(1100);
        animCrush.setRepeatCount(ValueAnimator.INFINITE);

        animBest = ObjectAnimator.ofFloat(rowBest, View.ROTATION, 0f, 360f);
        animBest.setDuration(1200);
        animBest.setRepeatCount(ValueAnimator.INFINITE);

        rowMom.setOnLongClickListener(v -> { toggle(animMom); return true; });
        rowDad.setOnLongClickListener(v -> { toggle(animDad); return true; });
        rowCrush.setOnLongClickListener(v -> { toggle(animCrush); return true; });
        rowBest.setOnLongClickListener(v -> { toggle(animBest); return true; });
    }

    private void dial(String telUri) {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(telUri));
        startActivity(i);
    }

    private void toggle(ObjectAnimator a) {
        if (a.isRunning()) a.cancel(); else a.start();
    }
}
