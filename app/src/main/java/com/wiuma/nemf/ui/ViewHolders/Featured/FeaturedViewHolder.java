package com.wiuma.nemf.ui.ViewHolders.Featured;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.ui.Adapters.Featured.FeaturedItemRVA;
import com.wiuma.nemf.ui.Decorators.PageIndicator;
import com.wiuma.nemf.Models.Featured;
import com.wiuma.nemf.R;

import java.util.List;

public class FeaturedViewHolder extends RecyclerView.ViewHolder {
    RecyclerView recycler;

    public FeaturedViewHolder(@NonNull View itemView) {
        super(itemView);
        recycler = itemView.findViewById(R.id.recycler);
    }

    public void setData(Context context, List<Featured> list) {
        FeaturedItemRVA adapter = new FeaturedItemRVA(context, list);
        recycler.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        if (recycler.getOnFlingListener() == null)
            snapHelper.attachToRecyclerView(recycler);
        recycler.addItemDecoration(new PageIndicator());
        recycler.setAdapter(adapter);
    }
}
