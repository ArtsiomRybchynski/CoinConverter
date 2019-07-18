package com.example.testproject.coin.detail.presenter.impl;

import com.example.testproject.source.Repository;
import com.example.testproject.entity.coin.Coin;
import com.example.testproject.coin.detail.presenter.CoinDetailPresenter;
import com.example.testproject.common.view.BaseView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CoinDetailPresenterImpl implements CoinDetailPresenter {

    private CoinDetailView coinDetailView;
    private Repository repository;

    public CoinDetailPresenterImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void getCoinById(int id) {
        repository.getCoinById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DatabaseSingleObserver());
    }

    @Override
    public void onAttach(BaseView view) {
        coinDetailView = (CoinDetailView) view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDetach() {
        coinDetailView = null;
    }

    private class DatabaseSingleObserver extends DisposableSingleObserver<Coin> {

        @Override
        public void onSuccess(Coin coin) {
            coinDetailView.showData(coin);
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
