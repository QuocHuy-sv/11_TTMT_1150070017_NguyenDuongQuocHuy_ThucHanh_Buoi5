package com.example.nguyenduongquochuylab3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitle(getString(R.string.title_vocab));
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(v -> finish());
        setSupportActionBar(tb);

        RecyclerView rv = findViewById(R.id.rvTopics);
        rv.setLayoutManager(new LinearLayoutManager(this));

        TopicAdapter ad = new TopicAdapter(TopicStore.TITLES, TopicStore.ICONS);
        rv.setAdapter(ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.act_search) {
            // TODO: mở ô search…
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
