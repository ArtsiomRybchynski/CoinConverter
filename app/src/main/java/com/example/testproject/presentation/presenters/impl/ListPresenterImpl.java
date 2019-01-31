package com.example.testproject.presentation.presenters.impl;

import com.example.testproject.data.repositories.Repository;
import com.example.testproject.domain.entities.Coin;
import com.example.testproject.domain.entities.DataObject;
import com.example.testproject.domain.entities.ResponseObject;
import com.example.testproject.presentation.presenters.ListPresenter;
import com.example.testproject.presentation.ui.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListPresenterImpl implements ListPresenter {

    private ListView mListView;
    private Repository mRepository;
    private List<DataObject> mDataObjects;
    private Coin mCoin;
    private List<Coin> mCoins = new ArrayList<>();

    public ListPresenterImpl(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void onAttach(BaseView view) {
        mListView = (ListView) view;
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
        mListView = null;
    }

    @Override
    public void requestCoins() {
        mListView.showProgressBar();
        mRepository.requestCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResponseObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ResponseObject responseObject) {
                        mDataObjects = responseObject.getDataObjects();

                        for (DataObject dataObject : mDataObjects) {
                            mCoin = dataObject.getCoin();
                            mCoin.setPrice(dataObject.getCurrency().getUsd().getPrice());
                            mCoins.add(mCoin);
                        }

                        mListView.showData(mCoins);
                        mListView.hideProgressBar();
                        mListView.notifyAdapter();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
