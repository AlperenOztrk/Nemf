package com.wiuma.nemf.ui.Adapters.NewProductsDetail;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Product;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.ViewHolders.NewProducts.NewProductsItemViewHolder;
import com.wiuma.nemf.ui.ViewHolders.NewProductsDetail.NewProductsDetailViewHolder;

import java.util.List;

public class NewProductsDetailRVA extends RecyclerView.Adapter<NewProductsDetailViewHolder> {
    Context context;
    List<Product> list;

    public NewProductsDetailRVA(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewProductsDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_new_products_item, parent, false);
        return new NewProductsDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewProductsDetailViewHolder holder, int position) {
        holder.setData(context, list.get(position));
        holder.itemView.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
