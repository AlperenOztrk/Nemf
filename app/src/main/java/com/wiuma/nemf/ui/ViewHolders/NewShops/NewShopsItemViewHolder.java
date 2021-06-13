package com.wiuma.nemf.ui.ViewHolders.NewShops;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wiuma.nemf.R;
import com.wiuma.nemf.Models.Shop;

public class NewShopsItemViewHolder extends RecyclerView.ViewHolder {
    ImageView logo, image;
    TextView logoText, storeName, storeDescription, productCount;

    public NewShopsItemViewHolder(@NonNull View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.logo);
        image = itemView.findViewById(R.id.image);
        logoText = itemView.findViewById(R.id.logoText);
        storeName = itemView.findViewById(R.id.storeName);
        storeDescription = itemView.findViewById(R.id.storeDescription);
        productCount = itemView.findViewById(R.id.productCount);
    }

    public void setData(Context context, Shop item) {
        storeName.setText(item.name);
        storeDescription.setText(item.definition);
        String count = item.productCount + context.getString(R.string.product);
        productCount.setText(count);
        if (item.logo == null) {
            logo.setVisibility(View.GONE);
            logoText.setVisibility(View.VISIBLE);
            logoText.setText(item.name.substring(0, 1));
        } else {
            logo.setVisibility(View.VISIBLE);
            logoText.setVisibility(View.GONE);
            Glide.with(context)
                    .load(item.logo.url)
                    .centerCrop()
                    .into(logo);
        }
        if (item.cover != null) {
            Glide.with(context)
                    .load(item.cover.url)
                    .centerCrop()
                    .into(image);
        }
        image.setClipToOutline(true);
    }
}
