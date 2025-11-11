package com.example.nguyenduongquochuylab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.VH> {
    private final String[] titles;
    private final int[] icons;

    public TopicAdapter(String[] titles, int[] icons) {
        this.titles = titles;
        this.icons = icons;
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        h.tv.setText(titles[pos]);
        int res = icons[pos];
        if (res == 0) res = R.drawable.ic_topic_dot;
        h.img.setImageResource(res);
    }

    @Override
    public int getItemCount() { return titles.length; }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img; TextView tv;
        VH(@NonNull View v) { super(v);
            img = v.findViewById(R.id.imgIcon);
            tv  = v.findViewById(R.id.tvTitle);
        }
    }
}
