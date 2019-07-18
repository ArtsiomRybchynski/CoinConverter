package com.example.testproject.coin.filter.presenter;

import com.example.testproject.entity.coin.Coin;
import com.example.testproject.common.presenter.BasePresenter;
import com.example.testproject.common.view.BaseView;

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
