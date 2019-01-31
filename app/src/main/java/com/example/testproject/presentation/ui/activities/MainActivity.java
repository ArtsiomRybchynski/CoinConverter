package com.example.testproject.presentation.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.testproject.R;
import com.example.testproject.presentation.ui.fragments.ListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private int mCurrentPageId = R.id.navigation_list;

    private FragmentManager mFragmentManager;

    @BindView(R.id.bottom_navigation_view) BottomNavigationView mBottomNavigationView;
    @BindView(R.id.toolbar_list) Toolbar toolbar;
    @BindView(R.id.tb_title) TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mFragmentManager = getSupportFragmentManager();
        beginTransaction(new ListFragment());

        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_list:
                                if (mCurrentPageId == menuItem.getItemId()) {
                                    return false;
                                } else {
                                    mCurrentPageId = menuItem.getItemId();
                                    textView.setText(R.string.currencies_list);
                                    replaceFragment(new ListFragment());
                                    return true;
                                }
                            case R.id.navigation_converter:
                                if (mCurrentPageId == menuItem.getItemId()) {
                                    return false;
                                } else {
                                    mCurrentPageId = menuItem.getItemId();
                                    textView.setText(R.string.converter);
//                                    replaceFragment(new ListFragment());
                                    return true;
                                }
                        }
                        return false;
                    }
                }
        );

    }

    private void beginTransaction(Fragment fragment) {
        mFragmentManager.beginTransaction()
                .add(R.id.frame_container, fragment)
                .commit();
    }

    private void replaceFragment(Fragment fragment) {
        mFragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit();
    }
}
