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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtAmount;
    private Spinner spFromCurrency;
    private ListView lvResult;

    private String[] currencyNames;
    private String[] currencyUnits;
    private int[] currencyFlags;

    private double[][] rates;
    private double[] results;

    private int fromIndex = 0;
    private CurrencyAdapter adapter;
    private DecimalFormat df = new DecimalFormat("0.#####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAmount = findViewById(R.id.edtAmount);
        spFromCurrency = findViewById(R.id.spFromCurrency);
        lvResult = findViewById(R.id.lvResult);

        initData();
        setupSpinner();
        setupListView();
        setupEvents();

        edtAmount.setText("123");
        updateResult();
    }

    private void initData() {
        currencyNames = new String[]{
                getString(R.string.usd_name),
                getString(R.string.eur_name),
                getString(R.string.gbp_name),
                getString(R.string.inr_name),
                getString(R.string.aud_name),
                getString(R.string.cad_name),
                getString(R.string.zar_name),
                getString(R.string.nzd_name),
                getString(R.string.jpy_name),
                getString(R.string.vnd_name)
        };

        currencyUnits = new String[]{
                getString(R.string.usd_unit),
                getString(R.string.eur_unit),
                getString(R.string.gbp_unit),
                getString(R.string.inr_unit),
                getString(R.string.aud_unit),
                getString(R.string.cad_unit),
                getString(R.string.zar_unit),
                getString(R.string.nzd_unit),
                getString(R.string.jpy_unit),
                getString(R.string.vnd_unit)
        };

        currencyFlags = new int[]{
                R.drawable.flag_usd,
                R.drawable.flag_eur,
                R.drawable.flag_gbp,
                R.drawable.flag_inr,
                R.drawable.flag_aud,
                R.drawable.flag_cad,
                R.drawable.flag_zar,
                R.drawable.flag_nzd,
                R.drawable.flag_jpy,
                R.drawable.flag_vnd
        };

        rates = new double[][]{
                {1, 0.80518, 0.6407, 63.3318, 1.21828, 1.16236, 11.7129, 1.2931, 118.337, 21385.7},
                {1.24172, 1, 0.79575, 78.6084, 1.51266, 1.44314, 14.5371, 1.60576, 146.927, 26561.8},
                {1.56044, 1.25667, 1, 98.7848, 1.90091, 1.81355, 18.2683, 2.01791, 184.638, 33374.9},
                {0.0158, 0.01272, 0.01012, 1, 0.01924, 0.01836, 0.18493, 0.02043, 1.8691, 337.811},
                {0.82114, 0.66119, 0.5262, 52.086, 1, 0.95416, 9.61148, 1.06158, 97.112, 17567.9},
                {0.86059, 0.69296, 0.55148, 54.5885, 1.04804, 1, 10.0732, 1.11258, 101.777, 18401.7},
                {0.08541, 0.06877, 0.05473, 5.40852, 0.10398, 0.09924, 1, 0.11037, 10.0996, 1825.87},
                {0.77402, 0.62319, 0.49597, 49.0031, 0.94215, 0.89951, 9.06754, 1, 91.5139, 16552.1},
                {0.00846, 0.00681, 0.00542, 0.53547, 0.0103, 0.00983, 0.09908, 0.01093, 1, 180.837},
                {0.00005, 0.00004, 0.00003, 0.00296, 0.00006, 0.00005, 0.00055, 0.00006, 0.00553, 1}
        };

        results = new double[currencyNames.length];
    }

    private void setupSpinner() {
        ArrayAdapter<String> spAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyUnits);
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFromCurrency.setAdapter(spAdapter);
        spFromCurrency.setSelection(6);
    }

    private void setupListView() {
        adapter = new CurrencyAdapter();
        lvResult.setAdapter(adapter);
    }

    private void setupEvents() {
        spFromCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromIndex = position;
                updateResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        edtAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
    }

    private void updateResult() {
        String text = edtAmount.getText().toString().trim();
        double amount = 0;
        if (!text.isEmpty()) {
            try {
                amount = Double.parseDouble(text);
            } catch (NumberFormatException ignored) {
            }
        }

        for (int i = 0; i < results.length; i++) {
            results[i] = amount * rates[i][fromIndex];
        }

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private class CurrencyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return currencyNames.length;
        }

        @Override
        public Object getItem(int position) {
            return currencyNames[position];
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
                convertView = inflater.inflate(R.layout.item_currency, parent, false);
                holder = new ViewHolder();
                holder.imgFlag = convertView.findViewById(R.id.imgFlag);
                holder.tvName = convertView.findViewById(R.id.tvName);
                holder.tvValue = convertView.findViewById(R.id.tvValue);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.imgFlag.setImageResource(currencyFlags[position]);
            holder.tvName.setText(currencyUnits[position] + " - " + currencyNames[position]);
            holder.tvValue.setText(df.format(results[position]));

            return convertView;
        }

        class ViewHolder {
            ImageView imgFlag;
            TextView tvName;
            TextView tvValue;
        }
    }
}
