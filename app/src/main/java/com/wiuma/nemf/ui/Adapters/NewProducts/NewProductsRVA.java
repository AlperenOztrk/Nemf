package com.wiuma.nemf.ui.Adapters.NewProducts;

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

import java.util.List;

public class NewProductsRVA extends RecyclerView.Adapter<NewProductsItemViewHolder> {
    Context context;
    List<Product> list;
    private int delayAnimate = 200;

    public NewProductsRVA(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewProductsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_new_products_item, parent, false);
        return new NewProductsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewProductsItemViewHolder holder, int position) {
        holder.setData(context, list.get(position));
        setAnimation(holder.itemView);
    }

    private void setAnimation(final View view) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_right);
            if (view != null) {
                view.startAnimation(animation);
                view.setVisibility(View.VISIBLE);
            }
        }, delayAnimate);
        delayAnimate += 200;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
