package com.example.nguyenduongquochuylab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContributorAdapter extends BaseAdapter {

    private final Context context;
    private final List<Contributor> data;
    private final LayoutInflater inflater;

    public ContributorAdapter(Context context, List<Contributor> data) {
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
            convertView = inflater.inflate(R.layout.item_contributor, parent, false);
            h = new ViewHolder();
            h.imgAvatar = convertView.findViewById(R.id.imgAvatar);
            h.tvName = convertView.findViewById(R.id.tvName);
            h.tvScore = convertView.findViewById(R.id.tvScore);
            convertView.setTag(h);
        } else {
            h = (ViewHolder) convertView.getTag();
        }

        Contributor c = data.get(position);
        h.tvName.setText(c.getName());
        h.tvScore.setText(c.getScore());
        h.imgAvatar.setImageResource(R.drawable.ic_avatar_placeholder);

        return convertView;
    }

    static class ViewHolder {
        ImageView imgAvatar;
        TextView tvName;
        TextView tvScore;
    }
}
