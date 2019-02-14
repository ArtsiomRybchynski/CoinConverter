package com.example.testproject.presentation.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.testproject.App;
import com.example.testproject.R;
import com.example.testproject.entities.Coin;
import com.example.testproject.presentation.presenters.CoinFilterPresenter;
import com.example.testproject.presentation.presenters.impl.CoinFilterPresenterImpl;
import com.example.testproject.presentation.ui.adapters.FilterListAdapter;

import java.util.List;

public class CoinFilterActivity extends AppCompatActivity
        implements CoinFilterPresenter.CoinFilterView {

    @BindView(R.id.tbFilterScreen)
    Toolbar toolbar;

    @BindView(R.id.rvFilterList)
    RecyclerView recyclerView;

    private FilterListAdapter adapter;
    private CoinFilterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_filter);
        ButterKnife.bind(this);

        initToolbar();

        initAdapter();

        presenter = new CoinFilterPresenterImpl(App.getRepository());
        presenter.onAttach(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getCoins();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_coin_filter_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveChangesButton :
                presenter.updateCoins(
                        adapter.getChangedData()
                );
                return true;
            case R.id.removeAllButton :
                adapter.setChecked(false);
                return true;
            case R.id.selectAllButton :
                adapter.setChecked(true);
                return true;
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showData(List<Coin> coins) {
        adapter.setData(coins);
    }

    @Override
    public void finishView() {
        this.finish();
    }

    @Override
    public void setResultOk() {
        setResult(Activity.RESULT_OK);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initAdapter() {
        adapter = new FilterListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
