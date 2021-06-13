package com.wiuma.nemf.ui.ViewHolders.EditorsChoiceShops;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wiuma.nemf.Models.Shop;
import com.wiuma.nemf.R;

public class EditorsChoiceShopsItemViewHolder extends RecyclerView.ViewHolder {
    ImageView logo, image_1, image_2, image_3;
    TextView storeName, storeDescription;

    public EditorsChoiceShopsItemViewHolder(@NonNull View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.logo);
        image_1 = itemView.findViewById(R.id.image_1);
        image_2 = itemView.findViewById(R.id.image_2);
        image_3 = itemView.findViewById(R.id.image_3);
        storeName = itemView.findViewById(R.id.storeName);
        storeDescription = itemView.findViewById(R.id.storeDescription);
    }

    public void setData(Context context, Shop item) {
        storeName.setText(item.name);
        storeDescription.setText(item.definition);
        Glide.with(context)
                .load(item.logo.url)
                .centerCrop()
                .into(logo);
        Glide.with(context)
                .load(item.popularProducts.get(0).images.get(0).url)
                .centerCrop()
                .into(image_1);
        image_1.setClipToOutline(true);
        Glide.with(context)
                .load(item.popularProducts.get(1).images.get(0).url)
                .centerCrop()
                .into(image_2);
        image_2.setClipToOutline(true);
        Glide.with(context)
                .load(item.popularProducts.get(2).images.get(0).url)
                .centerCrop()
                .into(image_3);
        image_3.setClipToOutline(true);
    }
}
