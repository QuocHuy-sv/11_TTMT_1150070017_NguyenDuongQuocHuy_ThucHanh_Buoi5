package com.example.nguyenduongquochuylab;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("CustomGridView");
        }

        gvCountry = findViewById(R.id.gvCountry);

        List<Country> list = new ArrayList<>();
        list.add(new Country("Vietnam",       "98000000",   R.drawable.flag_vietnam));
        list.add(new Country("United States", "320000000",  R.drawable.flag_usa));
        list.add(new Country("Russia",        "142000000",  R.drawable.flag_russia));
        list.add(new Country("Australia",     "23765305",   R.drawable.flag_australia));
        list.add(new Country("Japan",         "126788677",  R.drawable.flag_japan));

        CountryAdapter adapter = new CountryAdapter(this, list);
        gvCountry.setAdapter(adapter);

        gvCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Country c = (Country) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        c.getName() + " - dân số " + c.getPopulation(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
