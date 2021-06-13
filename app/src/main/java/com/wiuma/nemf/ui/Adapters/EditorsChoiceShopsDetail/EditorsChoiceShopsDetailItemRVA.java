package com.wiuma.nemf.ui.Adapters.EditorsChoiceShopsDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Shop;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.ViewHolders.EditorsChoiceShopsDetail.EditorsChoiceShopsDetailViewHolder;

import java.util.List;

public class EditorsChoiceShopsDetailItemRVA extends RecyclerView.Adapter<EditorsChoiceShopsDetailViewHolder> {
    Context context;
    List<Shop> list;

    public EditorsChoiceShopsDetailItemRVA(Context context, List<Shop> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EditorsChoiceShopsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_shops_detail, parent, false);
        return new EditorsChoiceShopsDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditorsChoiceShopsDetailViewHolder holder, int position) {
        holder.setData(context, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
