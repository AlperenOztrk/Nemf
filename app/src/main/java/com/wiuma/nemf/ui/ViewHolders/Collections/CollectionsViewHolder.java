package com.wiuma.nemf.ui.ViewHolders.Collections;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.Models.Collection;
import com.wiuma.nemf.R;
import com.wiuma.nemf.Models.Showcase;
import com.wiuma.nemf.ui.Adapters.Collections.CollectionsItemRVA;
import com.wiuma.nemf.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class CollectionsViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    RecyclerView recycler;
    LinearLayout more;
    Showcase item;
    List<Collection> list;

    public CollectionsViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        recycler = itemView.findViewById(R.id.recycler);
        more = itemView.findViewById(R.id.more);
    }

    public void setData(Context context, Showcase item, List<Collection> list) {
        this.list = list;
        this.item = item;
        title.setText(item.title);
        CollectionsItemRVA adapter = new CollectionsItemRVA(context, list);
        recycler.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        if (recycler.getOnFlingListener() == null)
            snapHelper.attachToRecyclerView(recycler);
        recycler.setAdapter(adapter);
        more.setOnClickListener((v) -> goToDetails(context));
    }

    private void goToDetails(Context context) {
        Intent i = new Intent(context, DetailsActivity.class);
        i.putExtra("type", item.type);
        i.putExtra("data", new ArrayList<>(list));
        context.startActivity(i);
    }
}
