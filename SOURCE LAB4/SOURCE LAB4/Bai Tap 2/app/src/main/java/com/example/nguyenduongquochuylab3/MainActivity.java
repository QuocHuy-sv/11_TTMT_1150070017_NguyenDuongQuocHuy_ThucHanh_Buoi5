package com.example.nguyenduongquochuylab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

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

        TopicAdapter ad = new TopicAdapter(
                TopicStore.TITLES,
                TopicStore.ICONS,
                new TopicAdapter.OnTopicListener() {
                    @Override
                    public void onClick(int position) {
                        String[] words = TopicStore.getWords(position);
                        String msg = words.length == 0 ? "No words"
                                : String.join(", ",
                                Arrays.copyOfRange(words, 0, Math.min(5, words.length)));
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(int position) {
                        Intent i = new Intent(MainActivity.this, VocabActivity.class);
                        i.putExtra("title", TopicStore.TITLES[position]);
                        i.putExtra("index", position);
                        startActivity(i);
                    }
                }
        );
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
