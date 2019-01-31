package com.example.testproject.presentation.presenters.base;

import com.example.testproject.presentation.ui.BaseView;

public interface BasePresenter {

    void onAttach(BaseView view);

    void onResume();

    void onPause();

    void onStop();

    void onDetach();
}
