package com.wiuma.nemf.ui.ViewHolders.EditorsChoiceShops;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wiuma.nemf.Models.Shop;
import com.wiuma.nemf.R;
import com.wiuma.nemf.Models.Showcase;
import com.wiuma.nemf.ui.Adapters.EditorsChoiceShops.EditorsChoiceShopsItemRVA;
import com.wiuma.nemf.ui.details.DetailsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EditorsChoiceShopsViewHolder extends RecyclerView.ViewHolder {
    ImageView background;
    TextView title;
    RecyclerView recycler;
    LinearLayout more;
    LinearLayoutManager layoutManager;
    Showcase item;
    List<Shop> list;

    public EditorsChoiceShopsViewHolder(@NonNull View itemView) {
        super(itemView);
        background = itemView.findViewById(R.id.background);
        title = itemView.findViewById(R.id.title);
        recycler = itemView.findViewById(R.id.recycler);
        more = itemView.findViewById(R.id.more);
    }

    public void setData(Context context, Showcase item, List<Shop> list) {
        this.list = list;
        this.item = item;
        title.setText(item.title);
        EditorsChoiceShopsItemRVA adapter = new EditorsChoiceShopsItemRVA(context, itemView, list);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recycler.setLayoutManager(layoutManager);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        if (recycler.getOnFlingListener() == null)
            snapHelper.attachToRecyclerView(recycler);
        recycler.setAdapter(adapter);
        activeScrollListener(context, list);
        setBackground(context, list.get(0).cover.url);
        more.setOnClickListener((v) -> goToDetails(context));
    }

    private void goToDetails(Context context) {
        Intent i = new Intent(context, DetailsActivity.class);
        i.putExtra("type", item.type);
        i.putExtra("data", new ArrayList<>(list));
        context.startActivity(i);
    }

    private void activeScrollListener(Context context, List<Shop> list) {
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int position = layoutManager.findFirstCompletelyVisibleItemPosition();
                    setBackground(context, list.get(position).cover.url);
                }
            }

            @Override
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition();
                Log.println(Log.ASSERT, "onScrollStateChanged", firstVisibleItem + " - " + layoutManager.findFirstCompletelyVisibleItemPosition());

            }
        });
    }

    private void setBackground(Context context, String url) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(background);
    }
}
