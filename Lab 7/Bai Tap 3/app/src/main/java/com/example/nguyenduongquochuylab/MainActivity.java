package com.example.nguyenduongquochuylab;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar sbR, sbG, sbB;
    private TextView tvR, tvG, tvB;
    private View viewRgb, viewCmy;

    private int r = 0, g = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ChooseColor");
        }

        sbR = findViewById(R.id.sbR);
        sbG = findViewById(R.id.sbG);
        sbB = findViewById(R.id.sbB);

        tvR = findViewById(R.id.tvR);
        tvG = findViewById(R.id.tvG);
        tvB = findViewById(R.id.tvB);

        viewRgb = findViewById(R.id.viewRgb);
        viewCmy = findViewById(R.id.viewCmy);

        setupSeekBar(sbR, tvR, "R", 255, 26);
        setupSeekBar(sbG, tvG, "G", 255, 116);
        setupSeekBar(sbB, tvB, "B", 0,   0);

        updateColors();
    }

    private void setupSeekBar(SeekBar seekBar, TextView label, String prefix,
                              int max, int startValue) {
        seekBar.setMax(255);
        seekBar.setProgress(startValue);
        label.setText(prefix + " = " + startValue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                label.setText(prefix + " = " + progress);
                switch (prefix) {
                    case "R":
                        r = progress;
                        break;
                    case "G":
                        g = progress;
                        break;
                    case "B":
                        b = progress;
                        break;
                }
                updateColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    private void updateColors() {
        int rgbColor = Color.rgb(r, g, b);
        int c = 255 - r;
        int m = 255 - g;
        int y = 255 - b;
        int cmyColor = Color.rgb(c, m, y);

        viewRgb.setBackgroundColor(rgbColor);
        viewCmy.setBackgroundColor(cmyColor);
    }
}
