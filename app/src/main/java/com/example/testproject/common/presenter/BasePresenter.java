package com.example.testproject.common.presenter;

import com.example.testproject.common.view.BaseView;

public interface BasePresenter {

    void onAttach(BaseView view);

    void onResume();

    void onPause();

    void onStop();

    void onDetach();
}
