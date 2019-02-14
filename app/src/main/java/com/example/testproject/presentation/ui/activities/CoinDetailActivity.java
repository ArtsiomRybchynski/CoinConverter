package com.example.testproject.presentation.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testproject.App;
import com.example.testproject.GlideApp;
import com.example.testproject.R;
import com.example.testproject.entities.Coin;
import com.example.testproject.presentation.presenters.CoinDetailPresenter;
import com.example.testproject.presentation.presenters.impl.CoinDetailPresenterImpl;

public class CoinDetailActivity extends AppCompatActivity implements
        CoinDetailPresenter.CoinDetailView {

    private static final String COIN_ID = "coinId";

    private CoinDetailPresenter presenter;

    @BindView(R.id.tbCoinDetailScreen)
    Toolbar toolbar;

    @BindView(R.id.ivCoinIcon)
    ImageView ivCoinIcon;

    @BindView(R.id.tvCoinName)
    TextView tvCoinName;

    @BindView(R.id.tvCoinFullName)
    TextView tvCoinFullName;

    @BindView(R.id.tvCoinAlgorithm)
    TextView tvCoinAlgorithm;

    @BindView(R.id.tvCoinPriceUsd)
    TextView tvCoinPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_detail);
        ButterKnife.bind(this);

        initToolbar();

        presenter = new CoinDetailPresenterImpl(App.getRepository());
        presenter.onAttach(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle arguments = getIntent().getExtras();
        presenter.getCoinById(arguments.getInt(COIN_ID));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void showData(Coin coin) {
        GlideApp.with(this)
                .load(coin.getImageUrl())
                .onlyRetrieveFromCache(true)
                .into(ivCoinIcon);

        tvCoinName.setText(getString(R.string.coin_detail_name).concat(coin.getName()));
        tvCoinFullName.setText(getString(R.string.coin_detail_full_name).concat(coin.getFullName()));
        tvCoinAlgorithm.setText(getString(R.string.coin_detail_algorithm).concat(coin.getAlgorithm()));
        tvCoinPrice.setText(getString(R.string.coin_detail_price).concat(coin.getPrice()));
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
}
