package com.wiuma.nemf.ui.ViewHolders.Featured;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wiuma.nemf.Models.Featured;
import com.wiuma.nemf.R;

public class FeaturedItemViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView storeTitle, storeSubtitle;

    public FeaturedItemViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        storeTitle = itemView.findViewById(R.id.storeTitle);
        storeSubtitle = itemView.findViewById(R.id.storeSubtitle);
    }

    public void setData(Context context, Featured item) {
        storeTitle.setText(item.title);
        storeSubtitle.setText(item.subTitle);
        Glide.with(context)
                .load(item.cover.url)
                .centerCrop()
                .into(image);
        image.setClipToOutline(true);
    }
}
