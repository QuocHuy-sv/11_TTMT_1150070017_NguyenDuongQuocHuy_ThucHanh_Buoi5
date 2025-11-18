package com.example.nguyenduongquochuylab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {

    private final Context context;
    private final List<Country> data;
    private final LayoutInflater inflater;

    public CountryAdapter(Context context, List<Country> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder h;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_country, parent, false);
            h = new ViewHolder();
            h.imgFlag = convertView.findViewById(R.id.imgFlag);
            h.tvName = convertView.findViewById(R.id.tvName);
            h.tvPopulation = convertView.findViewById(R.id.tvPopulation);
            convertView.setTag(h);
        } else {
            h = (ViewHolder) convertView.getTag();
        }

        Country c = data.get(position);
        h.imgFlag.setImageResource(c.getFlagResId());
        h.tvName.setText(c.getName());
        h.tvPopulation.setText(c.getPopulation());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgFlag;
        TextView tvName;
        TextView tvPopulation;
    }
}
