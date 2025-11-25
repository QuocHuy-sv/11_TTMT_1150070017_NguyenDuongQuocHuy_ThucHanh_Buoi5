package com.example.nguyenduongquochuylab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class M002DetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView txtName, txtContent;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m002_act_detail);

        imgDetail = findViewById(R.id.imgDetail);
        txtName = findViewById(R.id.txtName);
        txtContent = findViewById(R.id.txtContent);
        btnBack = findViewById(R.id.btnBack);

        Bundle b = getIntent().getExtras();
        if(b != null){
            txtName.setText(b.getString("name"));
            imgDetail.setImageResource(b.getInt("img"));
            txtContent.setText(b.getString("desc"));
        }

        btnBack.setOnClickListener(v -> finish());
    }
}
