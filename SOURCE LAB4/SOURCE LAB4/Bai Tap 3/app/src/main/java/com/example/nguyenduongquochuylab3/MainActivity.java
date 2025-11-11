package com.example.nguyenduongquochuylab3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private TextView emojiToast;
    private final Handler handler = new Handler();
    private static final String FRAG_TAG = "EMOJI_FRAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiToast = findViewById(R.id.emojiToast);
        Button btnRandom = findViewById(R.id.btnRandom);

        EmojiFragment frag = new EmojiFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, frag, FRAG_TAG)
                .commit();

        btnRandom.setOnClickListener(v -> {
            Fragment f = getSupportFragmentManager().findFragmentByTag(FRAG_TAG);
            if (f instanceof EmojiFragment) {
                ((EmojiFragment) f).randomize();
            }
        });
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
