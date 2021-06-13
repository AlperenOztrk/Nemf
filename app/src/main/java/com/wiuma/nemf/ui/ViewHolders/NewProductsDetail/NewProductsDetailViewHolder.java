package com.wiuma.nemf.ui.ViewHolders.NewProductsDetail;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wiuma.nemf.Models.Product;
import com.wiuma.nemf.R;

public class NewProductsDetailViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView productName, storeName, price, oldPrice;

    public NewProductsDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        productName = itemView.findViewById(R.id.productName);
        storeName = itemView.findViewById(R.id.storeName);
        price = itemView.findViewById(R.id.price);
        oldPrice = itemView.findViewById(R.id.oldPrice);
    }

    public void setData(Context context, Product item) {
        productName.setText(item.title);
        storeName.setText(item.shop.name);
        price.setText(String.valueOf(item.price));
        if (item.oldPrice == null) oldPrice.setVisibility(View.GONE);
        else {
            oldPrice.setText(String.valueOf(item.oldPrice));
            oldPrice.setPaintFlags(oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        Glide.with(context)
                .load(item.images.get(0).medium.url)
                .centerCrop()
                .into(image);
        image.setClipToOutline(true);
        if (item.cargoTime == 1) {
            itemView.findViewById(R.id.fastShipping).setVisibility(View.VISIBLE);
        }
    }
}
