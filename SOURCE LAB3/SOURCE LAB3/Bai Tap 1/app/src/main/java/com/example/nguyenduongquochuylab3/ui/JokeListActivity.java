package com.example.nguyenduongquochuylab3.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nguyenduongquochuylab3.R;
import com.example.nguyenduongquochuylab3.adapter.JokeAdapter;
import com.example.nguyenduongquochuylab3.data.DataProvider;
import com.example.nguyenduongquochuylab3.data.Joke;
import com.example.nguyenduongquochuylab3.util.OrientationHelper;

public class JokeListActivity extends AppCompatActivity implements JokeAdapter.OnJokeClick {
    int catId;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_list);
        OrientationHelper.apply(this);

        catId = getIntent().getIntExtra("catId", 0);
        String name = getIntent().getStringExtra("catName");

        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitle(name);
        setSupportActionBar(tb);
        tb.setNavigationOnClickListener(v -> onBackPressed());

        RecyclerView rv = findViewById(R.id.rvJokes);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        JokeAdapter ad = new JokeAdapter(DataProvider.getJokes(catId), this);
        rv.setAdapter(ad);
    }

    @Override public void onClick(Joke j) {
        Intent i = new Intent(this, JokeDetailActivity.class);
        i.putExtra("title", j.title);
        i.putExtra("content", j.content);
        startActivity(i);
    }
}
