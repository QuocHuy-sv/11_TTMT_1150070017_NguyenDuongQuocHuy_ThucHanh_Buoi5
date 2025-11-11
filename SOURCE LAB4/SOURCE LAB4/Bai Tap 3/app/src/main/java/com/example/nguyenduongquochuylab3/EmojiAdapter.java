package com.example.nguyenduongquochuylab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.VH> {

    public interface OnEmojiClick { void onClick(String emoji); }

    private String[] data;
    private final OnEmojiClick listener;

    public EmojiAdapter(String[] data, OnEmojiClick listener) {
        this.data = data;
        this.listener = listener;
    }

    public void setData(String[] newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emoji, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int position) {
        String e = data[position];
        h.tv.setText(e);
        h.itemView.setOnClickListener(v -> listener.onClick(e));
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tv;
        VH(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvEmoji);
        }
    }
}
