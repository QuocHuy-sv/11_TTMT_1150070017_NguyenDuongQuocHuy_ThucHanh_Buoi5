package com.example.nguyenduongquochuylab3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView emojiToast;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emojiToast = findViewById(R.id.emojiToast);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new EmojiFragment())
                .commit();
    }

    public void showEmojiToast(String emoji) {
        emojiToast.setText(emoji);
        emojiToast.setVisibility(View.VISIBLE);
        emojiToast.animate().alpha(1f).setDuration(150).start();
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(() -> {
            emojiToast.animate().alpha(0f).setDuration(200).withEndAction(() -> {
                emojiToast.setVisibility(View.GONE);
            }).start();
        }, 1500);
    }
}
