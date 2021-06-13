package com.wiuma.nemf.ui.ViewHolders.Categories;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wiuma.nemf.Models.Category;
import com.wiuma.nemf.R;

public class CategoriesItemViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView categoryName;

    public CategoriesItemViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        categoryName = itemView.findViewById(R.id.name);
    }

    public void setData(Context context, Category item) {
        categoryName.setText(item.name);
        Glide.with(context)
                .load(item.cover.url)
                .centerCrop()
                .into(image);
        image.setClipToOutline(true);
    }
}
