package com.example.nguyenduongquochuylab3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS = "app_prefs";
    private static final String KEY_LANG = "pref_lang"; // "vi" hoặc "en"

    private boolean favored = false;
    private boolean isVi = false;

    private Toolbar tb;
    private TextView tvChip, tvDesc, btnLang;
    private ImageButton btnFav;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        tvChip = findViewById(R.id.tvChip);
        tvDesc = findViewById(R.id.tvDesc);
        btnLang = findViewById(R.id.btnLang);
        btnFav  = findViewById(R.id.btnFav);
        img     = findViewById(R.id.imgAnimal);

        int rabbitId = getResources().getIdentifier("rabbit", "drawable", getPackageName());
        if (rabbitId == 0) img.setImageResource(R.mipmap.ic_launcher);

        SharedPreferences sp = getSharedPreferences(PREFS, MODE_PRIVATE);
        String savedLang = sp.getString(KEY_LANG, null);
        if (savedLang == null) {
            savedLang = Locale.getDefault().getLanguage().equalsIgnoreCase("vi") ? "vi" : "en";
            sp.edit().putString(KEY_LANG, savedLang).apply();
        }
        isVi = savedLang.equals("vi");

        renderUi();

        btnLang.setOnClickListener(v -> {
            isVi = !isVi;
            sp.edit().putString(KEY_LANG, isVi ? "vi" : "en").apply();
            renderUi();
        });

        btnFav.setOnClickListener(v -> {
            favored = !favored;
            btnFav.setImageResource(favored ? R.drawable.ic_heart_filled : R.drawable.ic_heart);
            btnFav.setContentDescription(getString(
                    favored ? (isVi ? R.string.unfav_vi : R.string.unfav_en)
                            : (isVi ? R.string.fav_vi   : R.string.fav_en)
            ));
        });
    }

    private void renderUi() {
        btnLang.setText(isVi ? "EN" : "VI");

        String title = getString(isVi ? R.string.toolbar_title_vi : R.string.toolbar_title_en);
        String chip  = getString(isVi ? R.string.chip_title_vi    : R.string.chip_title_en);
        String desc  = getString(isVi ? R.string.desc_text_vi     : R.string.desc_text_en);

        tb.setTitle(title);
        tvChip.setText(chip);
        tvDesc.setText(desc);

        btnFav.setContentDescription(getString(
                favored ? (isVi ? R.string.unfav_vi : R.string.unfav_en)
                        : (isVi ? R.string.fav_vi   : R.string.fav_en)
        ));
    }
}
