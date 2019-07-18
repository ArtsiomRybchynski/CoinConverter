package com.example.testproject.coin.converter.presenter.impl;

import com.example.testproject.source.Repository;
import com.example.testproject.entity.coin.Coin;
import com.example.testproject.entity.price.SinglePriceResponse;
import com.example.testproject.coin.converter.presenter.ConverterPresenter;
import com.example.testproject.common.view.BaseView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ConverterPresenterImpl implements ConverterPresenter {

    private static final int DEFAULT_COIN_AND_CURRENCY_INDEX = 0;
    private int currencyIndex = 0;
    private int coinIndex = 0;

    private static final String USD_CURRENCY_NAME = "USD";
    private static final String EUR_CURRENCY_NAME = "EUR";
    private static final String RUB_CURRENCY_NAME = "RUB";
    private static final String BYN_CURRENCY_NAME = "BYN";

    private boolean coinToCurrency = true;

    private SinglePriceResponse singlePriceResponse;

    private Repository repository;

    private ConverterView converterView;

    private List<Coin> coins;

    private List<Coin> indexedCoins = new ArrayList<>();

    private List<String> currenciesNames = new ArrayList<>(Arrays.asList(
            USD_CURRENCY_NAME,
            EUR_CURRENCY_NAME,
            RUB_CURRENCY_NAME,
            BYN_CURRENCY_NAME
    ));

    public ConverterPresenterImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void requestSinglePrice() {
        repository.requestSinglePrice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new WebSingleObserver());
    }

    @Override
    public void getAllCoins() {
        repository.getAllCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    @Override
    public void reverse() {
        coinToCurrency = !coinToCurrency;
        showSinglePrice(DEFAULT_COIN_AND_CURRENCY_INDEX, DEFAULT_COIN_AND_CURRENCY_INDEX);

    }

    @Override
    public void onAttach(BaseView view) {
        converterView = (ConverterView) view;
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

    }

    //Костыль
    private void indexCoins(List<Coin> coins) {
        indexedCoins.addAll(coins);
    }

    private void showSinglePrice(int coinIndex, int currencyIndex) {
        if (coinToCurrency) {
            converterView.showSinglePrice(
                    indexedCoins.get(coinIndex).getName(),
                    String.valueOf(singlePriceResponse.getUsdPrice()),
                    currenciesNames.get(currencyIndex)
            );
        } else {
            double coinPrice;
            double currencyPrice = singlePriceResponse.getUsdPrice();
            coinPrice = 1 / currencyPrice;



            converterView.showSinglePrice(
                    currenciesNames.get(currencyIndex),
                    String.valueOf(coinPrice),
                    indexedCoins.get(coinIndex).getName()
            );

        }
    }

    private void showInCurrencyIcon(String source) {

        if (coinToCurrency) {
            converterView.showInCurrencyIcon(source, true);
        } else {
            converterView.showInCurrencyIcon(source, false);
        }

    }

    private void showOutCurrencyIcon(String source) {

        if (coinToCurrency) {
            converterView.showOutCurrencyIcon(source, true);
        } else {
            converterView.showOutCurrencyIcon(source, false);
        }

    }

    private class WebSingleObserver extends DisposableSingleObserver<SinglePriceResponse> {

        @Override
        public void onSuccess(SinglePriceResponse singlePriceResponse) {
            ConverterPresenterImpl.this.singlePriceResponse = singlePriceResponse;
            repository.getAllCoins()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DatabaseSingleObserver());
        }

        @Override
        public void onError(Throwable e) {

        }
    }

    private class DatabaseSingleObserver extends DisposableSingleObserver<List<Coin>> {

        @Override
        public void onSuccess(List<Coin> coins) {
            ConverterPresenterImpl.this.coins = coins;
            indexCoins(coins);

            showSinglePrice(DEFAULT_COIN_AND_CURRENCY_INDEX, DEFAULT_COIN_AND_CURRENCY_INDEX);

            showInCurrencyIcon(indexedCoins.get(DEFAULT_COIN_AND_CURRENCY_INDEX).getImageUrl());

            showOutCurrencyIcon(currenciesNames.get(DEFAULT_COIN_AND_CURRENCY_INDEX));
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
