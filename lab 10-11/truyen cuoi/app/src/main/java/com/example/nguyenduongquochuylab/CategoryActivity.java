package com.example.nguyenduongquochuylab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.example.nguyenduongquochuylab.adapter.CategoryAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView rcv;
    ArrayList<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        rcv = findViewById(R.id.rcvCategory);

        loadCategories();

        CategoryAdapter adapter = new CategoryAdapter(this, list);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);
    }


    private void loadCategories() {
        try {
            AssetManager am = getAssets();
            String[] imgs = am.list("photo");
            String[] stories = am.list("story");

            if (imgs == null || stories == null) {
                Log.e("HUY_DEBUG", "⚠ Assets folder NOT FOUND!");
                return;
            }

            for (String img : imgs) {

                String base = img.substring(0, img.lastIndexOf("."));
                String txt = base + ".txt";

                boolean exists = false;
                for (String s : stories) {
                    if (s.equals(txt)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    String vietnameseName = convertToVietnamese(base);
                    list.add(new Category(vietnameseName, img));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertToVietnamese(String base) {
        switch (base) {
            case "BaiGiangVeTinhYeu": return "Bài giảng về tình yêu";
            case "BaiHocVeThucVat": return "Bài học về thực vật";
            case "BaiKiemTraDacBiet": return "Bài kiểm tra đặc biệt";
            case "ChauLucVaBanDo": return "Châu lục và bản đồ";
            case "ChuaBaiChoDung": return "Chữa bài cho đúng";
            case "DoDoanTenConVat": return "Đố đoán tên con vật";
            case "GiaiPhapDacBiet": return "Giải pháp đặc biệt";
            case "KetQuaKhongNgo": return "Kết quả không ngờ";
            case "LyThuyetVeBaiKiemTra": return "Lý thuyết về bài kiểm tra";
            case "ThayGiaoBatNgo": return "Thầy giáo bất ngờ";
        }
        return base;
    }
}
