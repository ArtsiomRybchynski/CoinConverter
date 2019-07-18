package com.example.testproject.common.router;

import android.content.Context;
import android.content.Intent;

import com.example.testproject.coin.detail.ui.activity.CoinDetailActivity;
import com.example.testproject.coin.filter.ui.activity.CoinFilterActivity;
import com.example.testproject.coin.list.ui.activitiy.MainActivity;
import com.example.testproject.coin.converter.ui.fragment.ConverterFragment;
import com.example.testproject.coin.list.ui.fragment.ListFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Router {

    private static final String COIN_ID = "coinId";

    private static final String LIST_FRAGMENT_TAG = "LIST_FRAGMENT_TAG";
    private static final String CONVERTER_FRAGMENT_TAG = "CONVERTER_FRAGMENT_TAG";

    public static void openMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void openCoinFilterActivity(int requestCode, Context context) {
        Intent intent = new Intent(context, CoinFilterActivity.class);
        MainActivity mainActivity = (MainActivity) context;
        mainActivity.startActivityForResult(intent, requestCode);
    }


    public static void openCoinDetailActivity(Context context, int id) {
        Intent intent = new Intent(context, CoinDetailActivity.class);
        intent.putExtra(COIN_ID, id);
        context.startActivity(intent);
    }

    public static Fragment openFragment(FragmentManager fragmentManager, Fragment activeFragment,
                                        String tag, int containerId) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment requestedFragment = fragmentManager.findFragmentByTag(tag);

        if (activeFragment != null) {

            transaction.hide(activeFragment);

            if (requestedFragment != null) {
                transaction
                        .show(requestedFragment)
                        .commit();
            } else {
                requestedFragment = addFragment(transaction, tag, containerId);
            }

        } else {
            requestedFragment = addFragment(transaction, tag, containerId);
        }

        return requestedFragment;
    }

    private static Fragment addFragment(FragmentTransaction transaction, String tag, int containerId) {

        Fragment fragment = null;

        switch (tag) {
            case LIST_FRAGMENT_TAG:
                fragment = new ListFragment();
                transaction
                        .add(containerId, fragment, tag)
                        .commit();
                break;

            case CONVERTER_FRAGMENT_TAG:
                fragment = new ConverterFragment();
                transaction
                        .add(containerId, fragment, tag)
                        .commit();
                break;
        }
        return fragment;
    }
}
