package com.example.testproject.utils;

import android.content.Context;
import android.content.Intent;

import com.example.testproject.presentation.ui.activities.CoinDetailActivity;
import com.example.testproject.presentation.ui.activities.CoinFilterActivity;
import com.example.testproject.presentation.ui.activities.MainActivity;
import com.example.testproject.presentation.ui.fragments.ListFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Router {

    private static final String COIN_ID = "coinId";

    private static final String LIST_FRAGMENT_TAG = "list fragment tag";
    private static final String CONVERTER_FRAGMENT_TAG = "converter fragment tag";

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

    public static void openFragment(FragmentManager fragmentManager, String tag, int containerId) {
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            addFragment(fragmentManager, tag, containerId);
        } else {
            fragmentManager.beginTransaction()
                    .replace(containerId, fragment)
                    .commit();
        }
    }

    private static void addFragment(FragmentManager fragmentManager, String tag, int containerId) {
        switch (tag) {
            case LIST_FRAGMENT_TAG:
                fragmentManager.beginTransaction()
                        .add(containerId, new ListFragment(), tag)
                        .commit();
                break;

            case CONVERTER_FRAGMENT_TAG:
                //Todo добавление фрагмента
                break;
        }
    }
}
