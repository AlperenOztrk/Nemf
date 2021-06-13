package com.wiuma.nemf.ui.ViewHolders.CollectionsDetail;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wiuma.nemf.Models.Collection;
import com.wiuma.nemf.R;

public class CollectionsDetailViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView collectionTitle, collectionSubtitle;

    public CollectionsDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        collectionTitle = itemView.findViewById(R.id.collectionTitle);
        collectionSubtitle = itemView.findViewById(R.id.collectionSubtitle);
    }

    public void setData(Context context, Collection item) {
        collectionTitle.setText(item.title);
        collectionSubtitle.setText(item.definition);
        Glide.with(context)
                .load(item.cover.url)
                .centerCrop()
                .into(image);
        image.setClipToOutline(true);
    }
}
