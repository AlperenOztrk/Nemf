package com.wiuma.nemf.ui.Adapters.NewShops;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.R;
import com.wiuma.nemf.Models.Shop;
import com.wiuma.nemf.ui.ViewHolders.NewShops.NewShopsItemViewHolder;

import java.util.List;

public class NewShopsRVA extends RecyclerView.Adapter<NewShopsItemViewHolder> {
    Context context;
    List<Shop> list;
    private int delayAnimate = 200;

    public NewShopsRVA(Context context, List<Shop> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public NewShopsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cell_new_shops_item, parent, false);
        return new NewShopsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewShopsItemViewHolder holder, int position) {
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
