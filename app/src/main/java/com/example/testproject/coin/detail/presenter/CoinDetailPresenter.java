package com.example.testproject.coin.detail.presenter;

import com.example.testproject.entity.coin.Coin;
import com.example.testproject.common.presenter.BasePresenter;
import com.example.testproject.common.view.BaseView;

public interface CoinDetailPresenter extends BasePresenter {

    void getCoinById(int id);

    interface CoinDetailView extends BaseView {
        void showData(Coin coin);
    }
}
