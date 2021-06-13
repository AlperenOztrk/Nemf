package com.wiuma.nemf.ui.Adapters.NewShopsDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Shop;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.ViewHolders.NewShopsDetail.NewShopsDetailViewHolder;

import java.util.List;

public class NewShopsDetailRVA extends RecyclerView.Adapter<NewShopsDetailViewHolder> {
    Context context;
    List<Shop> list;

    public NewShopsDetailRVA(Context context, List<Shop> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewShopsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_shops_detail, parent, false);
        return new NewShopsDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewShopsDetailViewHolder holder, int position) {
        holder.setData(context, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
