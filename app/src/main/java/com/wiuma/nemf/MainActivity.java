package com.wiuma.nemf;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wiuma.nemf.ui.Adapters.Showcase.ShowcaseAdapter;
import com.wiuma.nemf.Models.Showcase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    MainActivityViewModel model;
    RecyclerView recycler;
    LinearLayout loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        model.fetchShowcase();
        findViews();
        startObservers();
    }

    private void findViews() {
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        loading = findViewById(R.id.loading);
        ((SwipeRefreshLayout) findViewById(R.id.layout)).setOnRefreshListener(this);
    }

    private void startObservers() {
        final Observer<ArrayList<Showcase>> showcaseObserver = this::setShowcase;
        model.data.observe(this, showcaseObserver);
    }

    private void setShowcase(ArrayList<Showcase> showcase) {
        loading.setVisibility(View.GONE);
        if (((SwipeRefreshLayout) findViewById(R.id.layout)).isRefreshing())
            ((SwipeRefreshLayout) findViewById(R.id.layout)).setRefreshing(false);
        ShowcaseAdapter adapter = new ShowcaseAdapter(this, showcase);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        model.fetchShowcase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.options_menu_main_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);

    }
}