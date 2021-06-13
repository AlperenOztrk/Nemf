package com.wiuma.nemf.ui.ViewHolders.Categories;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Category;
import com.wiuma.nemf.R;
import com.wiuma.nemf.Models.Showcase;
import com.wiuma.nemf.ui.Adapters.Categories.CategoriesRVA;

import java.util.List;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    RecyclerView recycler;

    public CategoriesViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        recycler = itemView.findViewById(R.id.recycler);
    }

    public void setData(Context context, Showcase item, List<Category> list) {
        title.setText(item.title);
        CategoriesRVA adapter = new CategoriesRVA(context, list);
        recycler.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        if (recycler.getOnFlingListener() == null)
            snapHelper.attachToRecyclerView(recycler);
        recycler.setAdapter(adapter);
    }
}
