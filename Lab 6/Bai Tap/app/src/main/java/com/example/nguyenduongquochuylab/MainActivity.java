package com.example.nguyenduongquochuylab;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtLength;
    private Spinner spFromUnit;
    private ListView lvResult;

    private String[] unitNames;
    private String[] unitShort;

    private double[][] rates;
    private double[] results;

    private int fromIndex = 0;
    private LengthAdapter adapter;
    private DecimalFormat df = new DecimalFormat("0.#####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLength = findViewById(R.id.edtLength);
        spFromUnit = findViewById(R.id.spFromUnit);
        lvResult = findViewById(R.id.lvResult);

        View header = getLayoutInflater().inflate(R.layout.header_length, lvResult, false);
        lvResult.addHeaderView(header, null, false);

        initData();
        setupSpinner();
        setupListView();
        setupEvents();

        edtLength.setText("1.23");
        updateResult();
    }

    private void initData() {
        unitNames = new String[]{
                getString(R.string.nm_name),
                getString(R.string.mile_name),
                getString(R.string.km_name),
                getString(R.string.li_name),
                getString(R.string.m_name),
                getString(R.string.yard_name),
                getString(R.string.foot_name),
                getString(R.string.inch_name)
        };

        unitShort = new String[]{
                getString(R.string.nm_unit),
                getString(R.string.mile_unit),
                getString(R.string.km_unit),
                getString(R.string.li_unit),
                getString(R.string.m_unit),
                getString(R.string.yard_unit),
                getString(R.string.foot_unit),
                getString(R.string.inch_unit)
        };

        rates = new double[][]{
                {1.00000000, 0.86897624, 0.53995680, 0.04937365, 0.00053996, 0.00049374, 0.00016458, 0.00001371},
                {1.15077945, 1.00000000, 0.62137130, 0.05681818, 0.00062137, 0.00056818, 0.00018939, 0.00001578},
                {1.85200000, 1.60934400, 1.00000000, 0.09144000, 0.00100000, 0.00091440, 0.00030480, 0.00002540},
                {20.2537183, 17.6000000, 10.9361330, 1.00000000, 0.01093613, 0.01000000, 0.00333333, 0.00027778},
                {1852.00000, 1609.34400, 1000.00000, 91.4400000, 1.00000000, 0.91440000, 0.30480000, 0.02540000},
                {2025.37183, 1760.00000, 1093.61330, 100.000000, 1.09361330, 1.00000000, 0.33333333, 0.02777778},
                {6076.11549, 5280.00000, 3280.83990, 300.000000, 3.28083990, 3.00000000, 1.00000000, 0.08333333},
                {72913.38583, 63360.00000, 39370.07870, 3600.00000, 39.37007870, 36.00000000, 12.00000000, 1.00000000}
        };

        results = new double[unitNames.length];
    }

    private void setupSpinner() {
        ArrayAdapter<String> spAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unitShort);
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFromUnit.setAdapter(spAdapter);
        spFromUnit.setSelection(1);
    }

    private void setupListView() {
        adapter = new LengthAdapter();
        lvResult.setAdapter(adapter);
    }

    private void setupEvents() {
        spFromUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromIndex = position;
                updateResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        edtLength.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
    }

    private void updateResult() {
        String text = edtLength.getText().toString().trim();
        double amount = 0;
        if (!text.isEmpty()) {
            try {
                amount = Double.parseDouble(text);
            } catch (NumberFormatException ignored) { }
        }

        for (int i = 0; i < results.length; i++) {
            results[i] = amount * rates[i][fromIndex];
        }

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private class LengthAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return unitNames.length;
        }

        @Override
        public Object getItem(int position) {
            return unitNames[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                convertView = inflater.inflate(R.layout.item_length, parent, false);
                holder = new ViewHolder();
                holder.tvValue = convertView.findViewById(R.id.tvValue);
                holder.tvUnitName = convertView.findViewById(R.id.tvUnitName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvValue.setText(df.format(results[position]));
            holder.tvUnitName.setText(unitNames[position]);

            return convertView;
        }

        class ViewHolder {
            TextView tvValue;
            TextView tvUnitName;
        }
    }
}
