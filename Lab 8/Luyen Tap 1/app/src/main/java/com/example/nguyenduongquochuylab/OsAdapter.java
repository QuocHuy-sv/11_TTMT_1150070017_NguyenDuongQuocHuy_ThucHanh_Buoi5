package com.example.nguyenduongquochuylab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OsAdapter extends ArrayAdapter<OsItem> {

    private final LayoutInflater inflater;

    public OsAdapter(@NonNull Context context, @NonNull OsItem[] data) {
        super(context, 0, data);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_os, parent, false);
            holder = new ViewHolder();
            holder.imgIcon = convertView.findViewById(R.id.imgIcon);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvDesc = convertView.findViewById(R.id.tvDesc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        OsItem item = getItem(position);
        if (item != null) {
            holder.imgIcon.setImageResource(item.getIconResId());
            holder.tvName.setText(item.getName());
            holder.tvDesc.setText(item.getDescription());
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imgIcon;
        TextView tvName;
        TextView tvDesc;
    }
}
