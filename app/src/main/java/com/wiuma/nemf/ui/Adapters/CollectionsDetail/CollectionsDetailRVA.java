package com.wiuma.nemf.ui.Adapters.CollectionsDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Collection;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.ViewHolders.Collections.CollectionsItemViewHolder;
import com.wiuma.nemf.ui.ViewHolders.CollectionsDetail.CollectionsDetailViewHolder;

import java.util.List;

public class CollectionsDetailRVA extends RecyclerView.Adapter<CollectionsDetailViewHolder> {
    Context context;
    List<Collection> list;

    public CollectionsDetailRVA(Context context, List<Collection> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CollectionsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_collections_item, parent, false);
        return new CollectionsDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsDetailViewHolder holder, int position) {
        holder.setData(context, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
