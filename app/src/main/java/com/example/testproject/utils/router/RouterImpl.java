package com.example.testproject.utils.router;

import android.content.Context;
import android.content.Intent;

import com.example.testproject.presentation.ui.activities.MainActivity;

public class RouterImpl implements Router {

    private Context mContext;

    public RouterImpl(Context context) {
        mContext = context;
    }

    @Override
    public void openMainScreen() {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void openFilterScreen() {
//        Intent intent = new Intent(mContext, MainActivity.class);
//        mContext.startActivity(intent);
    }
}
