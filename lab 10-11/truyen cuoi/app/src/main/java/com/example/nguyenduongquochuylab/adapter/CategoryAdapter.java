package com.example.nguyenduongquochuylab.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyenduongquochuylab.Category;
import com.example.nguyenduongquochuylab.R;
import com.example.nguyenduongquochuylab.StoryDetailActivity;

import java.io.InputStream;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context context;
    List<Category> list;

    public CategoryAdapter(Context c, List<Category> list){
        this.context = c;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int pos){
        Category c = list.get(pos);

        // Load ảnh
        try {
            InputStream is = context.getAssets().open("photo/" + c.photo);
            Bitmap bmp = BitmapFactory.decodeStream(is);
            h.img.setImageBitmap(bmp);
        } catch (Exception ignored) {}

        h.title.setText(c.title);

        h.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, StoryDetailActivity.class);

            String fileName = c.photo.replace(".png", ".txt");

            i.putExtra("storyFile", fileName);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount(){ return list.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;

        public ViewHolder(View v){
            super(v);
            img = v.findViewById(R.id.imgCategory);
            title = v.findViewById(R.id.txtCategory);
        }
    }
}
