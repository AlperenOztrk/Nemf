package com.wiuma.nemf.ui.Adapters.Showcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiuma.nemf.ui.ViewHolders.Categories.CategoriesViewHolder;
import com.wiuma.nemf.ui.ViewHolders.Collections.CollectionsViewHolder;
import com.wiuma.nemf.ui.ViewHolders.EditorsChoiceShops.EditorsChoiceShopsViewHolder;
import com.wiuma.nemf.ui.ViewHolders.Featured.FeaturedViewHolder;
import com.wiuma.nemf.ui.ViewHolders.NewProducts.NewProductsViewHolder;
import com.wiuma.nemf.ui.ViewHolders.NewShops.NewShopsViewHolder;
import com.wiuma.nemf.Models.Showcase;
import com.wiuma.nemf.R;

import java.util.ArrayList;

public class ShowcaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Showcase> showcaseItems;
    Context context;

    public ShowcaseAdapter(Context context, ArrayList<Showcase> showcaseItems) {
        this.context = context;
        this.showcaseItems = showcaseItems;
    }

    @Override
    public int getItemViewType(int position) {
        switch (showcaseItems.get(position).type) {
            case "featured":
                return 0;
            case "new_products":
                return 1;
            case "categories":
                return 2;
            case "collections":
                return 3;
            case "editor_shops":
                return 4;
            case "new_shops":
                return 5;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        if (viewType == 0) {
            view = inflater.inflate(R.layout.cell_featured, parent, false);
            viewHolder = new FeaturedViewHolder(view);
        } else if (viewType == 1) {
            view = inflater.inflate(R.layout.cell_new_products, parent, false);
            viewHolder = new NewProductsViewHolder(view);
        } else if (viewType == 2) {
            view = inflater.inflate(R.layout.cell_categories, parent, false);
            viewHolder = new CategoriesViewHolder(view);
        } else if (viewType == 3) {
            view = inflater.inflate(R.layout.cell_collections, parent, false);
            viewHolder = new CollectionsViewHolder(view);
        } else if (viewType == 4) {
            view = inflater.inflate(R.layout.cell_editor_shops, parent, false);
            viewHolder = new EditorsChoiceShopsViewHolder(view);
        } else if (viewType == 5) {
            view = inflater.inflate(R.layout.cell_new_shops, parent, false);
            viewHolder = new NewShopsViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (showcaseItems.get(position).type) {
            case "featured":
                FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
                featuredViewHolder.setData(context, showcaseItems.get(position).featured);
                break;
            case "new_products":
                NewProductsViewHolder newProductsViewHolder = (NewProductsViewHolder) holder;
                newProductsViewHolder.setData(context, showcaseItems.get(position), showcaseItems.get(position).products);
                break;
            case "categories":
                CategoriesViewHolder categoriesViewHolder = (CategoriesViewHolder) holder;
                categoriesViewHolder.setData(context, showcaseItems.get(position), showcaseItems.get(position).categories);
                break;
            case "collections":
                CollectionsViewHolder collectionsViewHolder = (CollectionsViewHolder) holder;
                collectionsViewHolder.setData(context, showcaseItems.get(position), showcaseItems.get(position).collections);
                break;
            case "editor_shops":
                EditorsChoiceShopsViewHolder editorsChoiceShopsViewHolder = (EditorsChoiceShopsViewHolder) holder;
                editorsChoiceShopsViewHolder.setData(context, showcaseItems.get(position), showcaseItems.get(position).shops);
                break;
            case "new_shops":
                NewShopsViewHolder newShopsViewHolder = (NewShopsViewHolder) holder;
                newShopsViewHolder.setData(context, showcaseItems.get(position), showcaseItems.get(position).shops);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return showcaseItems.size();
    }
}
