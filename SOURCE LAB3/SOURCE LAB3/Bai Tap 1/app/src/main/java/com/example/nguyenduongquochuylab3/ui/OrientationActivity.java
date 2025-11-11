package com.example.nguyenduongquochuylab3.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import com.example.nguyenduongquochuylab3.R;
import com.example.nguyenduongquochuylab3.util.OrientationHelper;

public class OrientationActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        OrientationHelper.apply(this);

        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitle("Bật/Tắt xoay màn hình");
        setSupportActionBar(tb);
        tb.setNavigationOnClickListener(v -> onBackPressed());

        SwitchCompat sw = findViewById(R.id.swRotate);
        sw.setChecked(OrientationHelper.isAllowed(this));
        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            OrientationHelper.setAllowed(OrientationActivity.this, isChecked);
            OrientationHelper.apply(OrientationActivity.this);
        });
    }
}
