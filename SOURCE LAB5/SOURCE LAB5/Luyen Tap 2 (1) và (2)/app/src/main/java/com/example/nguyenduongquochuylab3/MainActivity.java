package com.example.nguyenduongquochuylab3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    LinearLayout rowMom, rowDad, rowCrush, rowBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = findViewById(R.id.toolbar);
        tb.setTitle(getString(R.string.title_quickcall));
        setSupportActionBar(tb);

        rowMom = findViewById(R.id.rowMom);
        rowDad = findViewById(R.id.rowDad);
        rowCrush = findViewById(R.id.rowCrush);
        rowBest = findViewById(R.id.rowBest);

        rowMom.setOnClickListener(v -> dial(getString(R.string.tel_mom)));
        rowDad.setOnClickListener(v -> dial(getString(R.string.tel_dad)));
        rowCrush.setOnClickListener(v -> dial(getString(R.string.tel_crush)));
        rowBest.setOnClickListener(v -> dial(getString(R.string.tel_best)));
    }

    private void dial(String telUri) {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(telUri));
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.act_dial) {
            startActivity(new Intent(Intent.ACTION_DIAL));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
