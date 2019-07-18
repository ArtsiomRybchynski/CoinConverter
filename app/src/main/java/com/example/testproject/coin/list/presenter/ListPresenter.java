package com.example.testproject.coin.list.presenter;

import com.example.testproject.entity.coin.Coin;
import com.example.testproject.common.presenter.BasePresenter;
import com.example.testproject.common.view.BaseView;

import java.util.List;

public interface ListPresenter extends BasePresenter {

    void requestCoins();
    void getFilterCoins();

    interface ListFragmentView extends BaseView {
        void notifyAdapter();
        void showData(List<Coin> coins);
    }
}
