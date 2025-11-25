package com.example.nguyenduongquochuylab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class M001MenuActivity extends AppCompatActivity {

    FrameLayout circleContainer;
    Button btnXemThem;

    int[] images = {
            R.drawable.aries, R.drawable.taurus, R.drawable.gemini,
            R.drawable.cancer, R.drawable.leo, R.drawable.virgo,
            R.drawable.libra, R.drawable.scorpio, R.drawable.sagittarius,
            R.drawable.capricorn, R.drawable.aquarius, R.drawable.pisces
    };

    String[] names = {
            "Bạch Dương","Kim Ngưu","Song Tử","Cự Giải",
            "Sư Tử","Xử Nữ","Thiên Bình","Bọ Cạp",
            "Nhân Mã","Ma Kết","Bảo Bình","Song Ngư"
    };

    String[] descs = {
            "Mô tả Bạch Dương...","Mô tả Kim Ngưu...","Mô tả Song Tử...",
            "Mô tả Cự Giải...","Mô tả Sư Tử...","Mô tả Xử Nữ...",
            "Mô tả Thiên Bình...","Mô tả Bọ Cạp...","Mô tả Nhân Mã...",
            "Mô tả Ma Kết...","Mô tả Bảo Bình...","Mô tả Song Ngư..."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_menu);

        circleContainer = findViewById(R.id.circleContainer);
        btnXemThem = findViewById(R.id.btnXemThem);

        int centerX = 540;
        int centerY = 800;
        int radius = 300;

        for (int i = 0; i < 12; i++) {
            ImageView img = new ImageView(this);
            img.setImageResource(images[i]);

            int size = 200;
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size, size);


            double angle = Math.toRadians(i * 30);
            int x = (int)(centerX + radius * Math.cos(angle) - size/2);
            int y = (int)(centerY + radius * Math.sin(angle) - size/2);
            params.leftMargin = x;
            params.topMargin = y;

            img.setLayoutParams(params);

            int finalI = i;
            img.setOnClickListener(v -> {

                findViewById(R.id.txtCungTitle).setTag(names[finalI]);
                ((android.widget.TextView)findViewById(R.id.txtCungTitle)).setText(names[finalI]);
                ((android.widget.TextView)findViewById(R.id.txtCungDesc)).setText(descs[finalI]);
            });

            circleContainer.addView(img);
        }

        btnXemThem.setOnClickListener(v -> {
            String name = ((android.widget.TextView)findViewById(R.id.txtCungTitle)).getText().toString();
            int idx = 0;
            for (int i = 0; i < names.length; i++) if (names[i].equals(name)) idx = i;

            Intent intent = new Intent(M001MenuActivity.this, M002DetailActivity.class);
            intent.putExtra("imgRes", images[idx]);
            intent.putExtra("name", names[idx]);
            intent.putExtra("desc", descs[idx]);
            startActivity(intent);
        });
    }
}
