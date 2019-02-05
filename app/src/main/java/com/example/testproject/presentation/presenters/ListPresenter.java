package com.example.testproject.presentation.presenters;

import com.example.testproject.entities.Coin;
import com.example.testproject.presentation.presenters.base.BasePresenter;
import com.example.testproject.presentation.ui.BaseView;

import java.util.List;

public interface ListPresenter extends BasePresenter {

    void requestCoins();

    interface ListFragmentView extends BaseView {
        void notifyAdapter();
        void showData(List<Coin> coins);
    }
}
