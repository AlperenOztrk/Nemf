package com.wiuma.nemf.ui.Adapters.Featured;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Featured;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.ViewHolders.Featured.FeaturedItemViewHolder;

import java.util.List;

public class FeaturedItemRVA extends RecyclerView.Adapter<FeaturedItemViewHolder> {
    Context context;
    List<Featured> list;

    public FeaturedItemRVA(Context context, List<Featured> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public FeaturedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_featured_item, parent, false);
        return new FeaturedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedItemViewHolder holder, int position) {
        holder.setData(context, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
