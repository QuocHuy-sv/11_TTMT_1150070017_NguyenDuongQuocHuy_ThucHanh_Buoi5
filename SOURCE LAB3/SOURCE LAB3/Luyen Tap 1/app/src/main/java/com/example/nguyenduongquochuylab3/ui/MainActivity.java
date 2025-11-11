package com.example.nguyenduongquochuylab3.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nguyenduongquochuylab3.R;
import com.example.nguyenduongquochuylab3.adapter.CategoryAdapter;
import com.example.nguyenduongquochuylab3.data.Category;
import com.example.nguyenduongquochuylab3.data.DataProvider;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.OnCategoryClick {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitle("Truyện cười");
        setSupportActionBar(tb);

        RecyclerView rv = findViewById(R.id.rvCategories);
        rv.setLayoutManager(new LinearLayoutManager(this));
        CategoryAdapter ad = new CategoryAdapter(DataProvider.getCategories(), this);
        rv.setAdapter(ad);
    }

    @Override public void onClick(Category c) {
        Intent i = new Intent(this, JokeListActivity.class);
        i.putExtra("catId", c.id);
        i.putExtra("catName", c.title);
        startActivity(i);
    }
}
