package com.example.nguyenduongquochuylab3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class VocabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);

        String title = getIntent().getStringExtra("title");
        int index = getIntent().getIntExtra("index", 0);

        Toolbar tb = findViewById(R.id.toolbar_vocab);
        tb.setTitle(title);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(v -> finish());
        setSupportActionBar(tb);

        ListView lv = findViewById(R.id.lvWords);
        String[] words = TopicStore.getWords(index);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words));
    }
}
