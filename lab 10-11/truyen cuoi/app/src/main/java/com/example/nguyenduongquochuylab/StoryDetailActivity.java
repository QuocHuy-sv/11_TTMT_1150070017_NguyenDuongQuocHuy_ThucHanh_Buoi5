package com.example.nguyenduongquochuylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StoryDetailActivity extends AppCompatActivity {

    TextView txtStory;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        txtStory = findViewById(R.id.txtStory);

        fileName = getIntent().getStringExtra("storyFile");

        Log.d("HUY_DEBUG", "File nhận được = " + fileName);

        if (fileName != null) {
            loadStory(fileName);
        } else {
            txtStory.setText("Không tìm thấy file truyện!");
        }
    }

    private void loadStory(String fileName) {
        try {
            AssetManager am = getAssets();
            InputStream is = am.open("story/" + fileName);

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            txtStory.setText(sb.toString());

        } catch (IOException e) {
            txtStory.setText("Lỗi đọc file truyện: " + e.getMessage());
        }
    }
}
