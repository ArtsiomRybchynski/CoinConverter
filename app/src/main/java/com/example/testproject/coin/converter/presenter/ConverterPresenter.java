package com.example.testproject.coin.converter.presenter;

import com.example.testproject.common.presenter.BasePresenter;
import com.example.testproject.common.view.BaseView;

public interface ConverterPresenter extends BasePresenter {

    void requestSinglePrice();

    void getAllCoins();

    void reverse();

    interface ConverterView extends BaseView {
        void showSinglePrice(String innerCurrency, String price, String outerCurrency);
        void showInCurrencyIcon(String source, boolean coinToCurrency);
        void showOutCurrencyIcon(String source, boolean coinToCurrency);
        void updateView();
    }
}
