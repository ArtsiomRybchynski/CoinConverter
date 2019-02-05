package com.example.testproject.presentation.presenters.impl;

import com.example.testproject.repositories.Repository;
import com.example.testproject.entities.Coin;
import com.example.testproject.entities.CoinDescription;
import com.example.testproject.entities.RawResponse;
import com.example.testproject.presentation.presenters.ListPresenter;
import com.example.testproject.presentation.ui.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListPresenterImpl implements ListPresenter {

    private ListFragmentView listFragmentView;
    private Repository repository;
    private List<CoinDescription> coinDescriptions;
    private Coin coin;
    private List<Coin> coins = new ArrayList<>();

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
                .subscribe(new SingleObserver<RawResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(RawResponse rawResponse) {
                        coinDescriptions = rawResponse.getCoinDescriptions();

                        for (CoinDescription coinDescription : coinDescriptions) {
                            coin = coinDescription.getCoin();
                            coin.setPrice(coinDescription.getCurrencies().getUsdCurrency().getPrice());
                            coins.add(coin);
                        }

                        listFragmentView.showData(coins);
                        listFragmentView.hideProgressBar();
                        listFragmentView.notifyAdapter();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
