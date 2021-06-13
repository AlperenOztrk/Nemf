package com.wiuma.nemf.ui.details;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wiuma.nemf.Models.Collection;
import com.wiuma.nemf.Models.Product;
import com.wiuma.nemf.Models.Shop;
import com.wiuma.nemf.R;
import com.wiuma.nemf.ui.Adapters.CollectionsDetail.CollectionsDetailRVA;
import com.wiuma.nemf.ui.Adapters.EditorsChoiceShopsDetail.EditorsChoiceShopsDetailItemRVA;
import com.wiuma.nemf.ui.Adapters.NewProductsDetail.NewProductsDetailRVA;
import com.wiuma.nemf.ui.Adapters.NewShopsDetail.NewShopsDetailRVA;
import com.wiuma.nemf.ui.Functionality.Helper;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    String type;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        type = getIntent().getStringExtra("type");
        findViews();
    }

    private void findViews() {
        recycler = findViewById(R.id.recycler);
        ((SwipeRefreshLayout) findViewById(R.id.layout)).setOnRefreshListener(this);
        setView();
    }

    @SuppressWarnings("unchecked")
    private void setView() {
        switch (type) {
            case "new_products":
                recycler.setLayoutManager(new GridLayoutManager(this, 2));
                ArrayList<Product> products = (ArrayList<Product>) getIntent().getSerializableExtra("data");
                NewProductsDetailRVA productsDetailAdapter = new NewProductsDetailRVA(this, products);
                recycler.setAdapter(productsDetailAdapter);
                break;
            case "collections":
                recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                ArrayList<Collection> collections = (ArrayList<Collection>) getIntent().getSerializableExtra("data");
                CollectionsDetailRVA collectionsDetailAdapter = new CollectionsDetailRVA(this, collections);
                recycler.setAdapter(collectionsDetailAdapter);
                break;
            case "editor_shops":
                recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                ArrayList<Shop> editor_shops = (ArrayList<Shop>) getIntent().getSerializableExtra("data");
                EditorsChoiceShopsDetailItemRVA editorsChoiceShopsDetailItemAdapter = new EditorsChoiceShopsDetailItemRVA(this, editor_shops);
                recycler.setAdapter(editorsChoiceShopsDetailItemAdapter);
                break;
            case "new_shops":
                recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                ArrayList<Shop> new_shops = (ArrayList<Shop>) getIntent().getSerializableExtra("data");
                NewShopsDetailRVA newShopsDetailAdapter = new NewShopsDetailRVA(this, new_shops);
                recycler.setAdapter(newShopsDetailAdapter);
                break;
        }
        getSupportActionBar().setTitle(Helper.getResId(type, R.string.class));
    }

    private void refreshData() {
        if (((SwipeRefreshLayout) findViewById(R.id.layout)).isRefreshing())
            ((SwipeRefreshLayout) findViewById(R.id.layout)).setRefreshing(false);
        setView();
    }

    @Override
    public void onRefresh() {
        refreshData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
