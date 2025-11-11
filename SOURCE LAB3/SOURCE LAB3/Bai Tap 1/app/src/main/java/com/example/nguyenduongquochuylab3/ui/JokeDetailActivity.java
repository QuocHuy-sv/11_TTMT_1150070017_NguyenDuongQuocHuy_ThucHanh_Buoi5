package com.example.nguyenduongquochuylab3.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;
import com.example.nguyenduongquochuylab3.R;
import com.example.nguyenduongquochuylab3.util.OrientationHelper;

public class JokeDetailActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);
        OrientationHelper.apply(this);

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");

        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitle(title);
        setSupportActionBar(tb);
        tb.setNavigationOnClickListener(v -> onBackPressed());

        TextView tv = findViewById(R.id.tvContent);
        tv.setText(content);
    }
}
