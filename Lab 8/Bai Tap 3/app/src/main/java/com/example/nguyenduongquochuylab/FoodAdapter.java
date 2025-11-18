package com.example.nguyenduongquochuylab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private final Context context;
    private final List<Food> data;
    private final LayoutInflater inflater;

    public FoodAdapter(Context context, List<Food> data) {
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
            convertView = inflater.inflate(R.layout.item_food, parent, false);
            h = new ViewHolder();
            h.imgFood = convertView.findViewById(R.id.imgFood);
            h.tvName = convertView.findViewById(R.id.tvName);
            h.tvDesc = convertView.findViewById(R.id.tvDesc);
            h.tvPrice = convertView.findViewById(R.id.tvPrice);
            convertView.setTag(h);
        } else {
            h = (ViewHolder) convertView.getTag();
        }

        Food f = data.get(position);
        h.imgFood.setImageResource(f.getImageResId());
        h.tvName.setText(f.getName());
        h.tvDesc.setText(f.getDescription());
        h.tvPrice.setText(f.getPrice());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgFood;
        TextView tvName;
        TextView tvDesc;
        TextView tvPrice;
    }
}
