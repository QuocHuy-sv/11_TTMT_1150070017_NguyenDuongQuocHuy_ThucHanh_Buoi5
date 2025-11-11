package com.example.nguyenduongquochuylab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.VH> {

    public interface OnTopicListener {
        void onClick(int position);
        void onLongClick(int position);
    }

    private final String[] titles;
    private final int[] icons;
    private final OnTopicListener listener;

    public TopicAdapter(String[] titles, int[] icons, OnTopicListener l) {
        this.titles = titles;
        this.icons = icons;
        this.listener = l;
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
        if (res == 0) res = R.drawable.ic_topic_dot; // fallback nếu thiếu icon
        h.img.setImageResource(res);

        h.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onClick(h.getBindingAdapterPosition());
        });
        h.itemView.setOnLongClickListener(v -> {
            if (listener != null) listener.onLongClick(h.getBindingAdapterPosition());
            return true;
        });
    }

    @Override public int getItemCount() { return titles.length; }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img; TextView tv;
        VH(@NonNull View v) { super(v);
            img = v.findViewById(R.id.imgIcon);
            tv  = v.findViewById(R.id.tvTitle);
        }
    }
}
