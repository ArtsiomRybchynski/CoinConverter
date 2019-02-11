package com.example.testproject.presentation.presenters;

import com.example.testproject.entities.Coin;
import com.example.testproject.presentation.presenters.base.BasePresenter;
import com.example.testproject.presentation.ui.BaseView;

public interface CoinDetailPresenter extends BasePresenter {

    void getCoinById(int id);

    interface CoinDetailView extends BaseView {
        void showData(Coin coin);
    }
}
