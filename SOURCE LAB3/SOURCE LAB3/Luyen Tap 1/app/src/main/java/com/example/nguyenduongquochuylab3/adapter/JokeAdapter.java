package com.example.nguyenduongquochuylab3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nguyenduongquochuylab3.R;
import com.example.nguyenduongquochuylab3.data.Joke;
import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.VH> {

    public interface OnJokeClick { void onClick(Joke j); }

    private final List<Joke> items;
    private final OnJokeClick listener;

    public JokeAdapter(List<Joke> items, OnJokeClick l) {
        this.items = items; this.listener = l;
    }

    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_joke, parent, false);
        return new VH(v);
    }

    @Override public void onBindViewHolder(@NonNull VH h, int position) {
        Joke j = items.get(position);
        h.title.setText(j.title);
        h.itemView.setOnClickListener(v -> listener.onClick(j));
    }

    @Override public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView title;
        VH(@NonNull View v) { super(v); title = v.findViewById(R.id.tvJokeTitle); }
    }
}
