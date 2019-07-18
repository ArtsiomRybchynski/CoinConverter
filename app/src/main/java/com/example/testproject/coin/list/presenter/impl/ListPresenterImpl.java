package com.example.testproject.coin.list.presenter.impl;

import com.example.testproject.source.Repository;
import com.example.testproject.entity.coin.Coin;
import com.example.testproject.coin.list.presenter.ListPresenter;
import com.example.testproject.common.view.BaseView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListPresenterImpl implements ListPresenter {

    private ListFragmentView listFragmentView;
    private Repository repository;

    public ListPresenterImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void onAttach(BaseView view) {
        listFragmentView = (ListFragmentView) view;
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
        listFragmentView = null;
    }

    @Override
    public void requestCoins() {
        listFragmentView.showProgressBar();
        repository.requestCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new WebSingleObserver());
    }

    @Override
    public void getFilterCoins() {
        listFragmentView.showProgressBar();
        repository.getFilterCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DatabaseSingleObserver());
    }

    private class WebSingleObserver extends DisposableSingleObserver<List<Coin>>{

        @Override
        public void onSuccess(List<Coin> coins) {
            repository.getAllCoins()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DatabaseSingleObserver());
        }

        @Override
        public void onError(Throwable e) {
            repository.getAllCoins()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DatabaseSingleObserver());
        }
    }

    private class DatabaseSingleObserver extends DisposableSingleObserver<List<Coin>>{

        @Override
        public void onSuccess(List<Coin> coins) {
            listFragmentView.showData(coins);
            listFragmentView.hideProgressBar();
            listFragmentView.notifyAdapter();
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
