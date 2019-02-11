package com.example.testproject.presentation.ui.activities;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;

import com.example.testproject.R;
import com.example.testproject.presentation.ui.fragments.ListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private int currentPageId = R.id.navigationList;

    private FragmentManager fragmentManager;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.tbMainScreen)
    Toolbar toolbar;

    @BindView(R.id.tbTitle)
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fragmentManager = getSupportFragmentManager();
        addFragment(new ListFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.navigationList:
                            if (currentPageId == menuItem.getItemId()) {
                                return false;
                            } else {
                                currentPageId = menuItem.getItemId();
                                textView.setText(R.string.toolbar_currencies_list_title);
                                replaceFragment(new ListFragment());
                                return true;
                            }
                        case R.id.navigationConverter:
                            if (currentPageId == menuItem.getItemId()) {
                                return false;
                            } else {
                                currentPageId = menuItem.getItemId();
                                textView.setText(R.string.toolbar_converter_title);
//                                    replaceFragment(new ListFragment());
                                return true;
                            }
                    }
                    return false;
                }
        );

    }

    private void addFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .add(R.id.frameСontainer, fragment)
                .commit();
    }

    private void replaceFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.frameСontainer, fragment)
                .commit();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CoinDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
