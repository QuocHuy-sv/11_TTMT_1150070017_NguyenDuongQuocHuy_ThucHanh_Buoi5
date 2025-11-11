package com.example.nguyenduongquochuylab3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nguyenduongquochuylab3.R;
import com.example.nguyenduongquochuylab3.data.Category;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.VH> {

    public interface OnCategoryClick { void onClick(Category c); }

    private final List<Category> items;
    private final OnCategoryClick listener;

    public CategoryAdapter(List<Category> items, OnCategoryClick l) {
        this.items = items; this.listener = l;
    }

    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new VH(v);
    }

    @Override public void onBindViewHolder(@NonNull VH h, int pos) {
        Category c = items.get(pos);
        h.title.setText(c.title);
        h.icon.setImageResource(c.iconRes);
        h.itemView.setOnClickListener(v -> listener.onClick(c));
    }

    @Override public int getItemCount() { return items.size(); }

    static class VH extends RecyclerView.ViewHolder {
        ImageView icon; TextView title;
        VH(@NonNull View v) { super(v);
            icon = v.findViewById(R.id.imgIcon);
            title = v.findViewById(R.id.tvTitle);
        }
    }
}
