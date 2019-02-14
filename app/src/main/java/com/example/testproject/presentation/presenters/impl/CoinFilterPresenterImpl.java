package com.example.testproject.presentation.presenters.impl;

import com.example.testproject.data.Repository;
import com.example.testproject.entities.Coin;
import com.example.testproject.presentation.presenters.CoinFilterPresenter;
import com.example.testproject.presentation.ui.BaseView;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CoinFilterPresenterImpl implements CoinFilterPresenter {

    private Repository repository;
    private CoinFilterView coinFilterView;

    public CoinFilterPresenterImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void getCoins() {
        repository.getAllCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DatabaseSingleObserver());
    }

    @Override
    public void updateCoins(List<Coin> coins) {
        Completable.fromCallable((Callable<Void>) () -> {
            repository.updateCoins(coins);
            return null;
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DatabaseCompletableObserver());
    }

    @Override
    public void onAttach(BaseView view) {
        coinFilterView = (CoinFilterView) view;
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
        coinFilterView = null;
    }

    private class DatabaseSingleObserver extends DisposableSingleObserver<List<Coin>> {

        @Override
        public void onSuccess(List<Coin> coins) {
            coinFilterView.showData(coins);
            coinFilterView.notifyAdapter();
        }

        @Override
        public void onError(Throwable e) {

        }
    }

    private class DatabaseCompletableObserver implements CompletableObserver {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onComplete() {
            coinFilterView.setResultOk();
            coinFilterView.finishView();
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
