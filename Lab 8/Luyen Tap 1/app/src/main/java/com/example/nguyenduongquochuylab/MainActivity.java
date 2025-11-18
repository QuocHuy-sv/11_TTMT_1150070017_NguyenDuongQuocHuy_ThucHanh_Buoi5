package com.example.nguyenduongquochuylab;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView lvOs;
    private TextView tvSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Lab 7");
        }

        lvOs = findViewById(R.id.lvOs);
        tvSelection = findViewById(R.id.tvSelection);

        OsItem[] data = new OsItem[] {
                new OsItem("Android",
                        "Đây là hệ điều hành Android",
                        R.drawable.ic_android_os),
                new OsItem("iOS",
                        "Đây là hệ điều hành iOS",
                        R.drawable.ic_ios_os),
                new OsItem("Window Phone",
                        "Đây là hệ điều hành Window Phone",
                        R.drawable.ic_windows_os)
        };

        OsAdapter adapter = new OsAdapter(this, data);
        lvOs.setAdapter(adapter);

        lvOs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OsItem item = (OsItem) parent.getItemAtPosition(position);
                tvSelection.setText("Bạn chọn: " + item.getName());
            }
        });
    }
}
