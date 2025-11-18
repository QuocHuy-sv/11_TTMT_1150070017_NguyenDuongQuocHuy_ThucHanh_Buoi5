package com.example.nguyenduongquochuylab;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gvContributors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvContributors = findViewById(R.id.gvContributors);

        List<Contributor> list = new ArrayList<>();
        list.add(new Contributor("Maboo",          "283,297"));
        list.add(new Contributor("SameOldShawn",   "252,433"));
        list.add(new Contributor("Magnitude901",   "164,935"));
        list.add(new Contributor("Brandon",        "100,466"));
        list.add(new Contributor("Clement_RGF",    "93,932"));
        list.add(new Contributor("Nebja",          "84,187"));
        list.add(new Contributor("BBDS",           "81,762"));
        list.add(new Contributor("PleaseDe-ModMe", "79,243"));
        list.add(new Contributor("DLizzle",        "76,331"));
        list.add(new Contributor("palacelight",    "75,497"));
        list.add(new Contributor("TheDarkKnight",  "69,138"));
        list.add(new Contributor("hellrel",        "68,903"));

        ContributorAdapter adapter = new ContributorAdapter(this, list);
        gvContributors.setAdapter(adapter);

        gvContributors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Contributor c = (Contributor) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        c.getName() + " : " + c.getScore(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
