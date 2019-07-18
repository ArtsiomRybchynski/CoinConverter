package com.example.testproject.source;

import android.content.Context;

import com.example.testproject.source.local.LocalDataSource;
import com.example.testproject.source.remote.RemoteDataSource;
import com.example.testproject.source.remote.mapper.CoinMapper;
import com.example.testproject.entity.coin.Coin;
import com.example.testproject.entity.RawResponse;
import com.example.testproject.entity.price.SinglePriceResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class RepositoryImpl implements Repository {

    private Context context;

    private RemoteDataSource remoteSource;
    private LocalDataSource localSource;
    private List<Coin> coins;

    public RepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public Single<List<Coin>> requestCoins() {
        coins = new ArrayList<>();

        Single<RawResponse> rawResponseSingle = remoteSource.requestCoins();

        return rawResponseSingle
                .map(new CoinMapper<>(coins))
                .doOnSuccess(this::updateCoinTable);
    }

    @Override
    public Single<Coin> getCoinById(int id) {
        return localSource.getCoinById(id);
    }

    @Override
    public Single<List<Coin>> getAllCoins() {
        return localSource.getAllCoins();
    }

    @Override
    public Single<List<Coin>> getFilterCoins() {
        return localSource.getFilterCoins();
    }

    @Override
    public Single<SinglePriceResponse> requestSinglePrice() {
        return remoteSource.requestSinglePrice();
    }

    @Override
    public void insertCoins(List<Coin> coins) {
        localSource.insertCoins(coins);
    }

    @Override
    public void updateCoinTable(List<Coin> coins) {
        localSource.updateCoinTable(coins);
    }

    @Override
    public void updateCoins(List<Coin> coins) {
        localSource.updateCoins(coins);
    }

    @Override
    public void setRemoteSource(RemoteDataSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    public void setLocalSource(LocalDataSource localSource) {
        this.localSource = localSource;
    }

}
