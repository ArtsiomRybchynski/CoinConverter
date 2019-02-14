package com.example.testproject.presentation.presenters;

import com.example.testproject.entities.Coin;
import com.example.testproject.presentation.presenters.base.BasePresenter;
import com.example.testproject.presentation.ui.BaseView;

import java.util.List;

public interface CoinFilterPresenter extends BasePresenter {

    void getCoins();
    void updateCoins(List<Coin> coins);

    interface CoinFilterView extends BaseView {
        void notifyAdapter();
        void showData(List<Coin> coins);
        void finishView();
        void setResultOk();
    }
}
