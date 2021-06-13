package com.wiuma.nemf.ui.Adapters.EditorsChoiceShops;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Shop;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.ViewHolders.EditorsChoiceShops.EditorsChoiceShopsItemViewHolder;

import java.util.List;

public class EditorsChoiceShopsItemRVA extends RecyclerView.Adapter<EditorsChoiceShopsItemViewHolder> {
    Context context;
    List<Shop> list;
    View rootView;

    public EditorsChoiceShopsItemRVA(Context context, View rootView, List<Shop> list) {
        this.context = context;
        this.rootView = rootView;
        this.list = list;
    }

    @NonNull
    @Override
    public EditorsChoiceShopsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_editor_shops_item, parent, false);
        return new EditorsChoiceShopsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditorsChoiceShopsItemViewHolder holder, int position) {
        holder.setData(context, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
