package com.wiuma.nemf.ui.Adapters.Categories;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Category;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.ViewHolders.Categories.CategoriesItemViewHolder;

import java.util.List;

public class CategoriesRVA extends RecyclerView.Adapter<CategoriesItemViewHolder> {
    Context context;
    List<Category> list;
    private int delayAnimate = 200;

    public CategoriesRVA(Context context, List<Category> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public CategoriesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_categories_item, parent, false);
        return new CategoriesItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesItemViewHolder holder, int position) {
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
