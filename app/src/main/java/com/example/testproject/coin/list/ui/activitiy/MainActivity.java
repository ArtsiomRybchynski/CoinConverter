package com.example.testproject.coin.list.ui.activitiy;

import com.example.testproject.common.router.Router;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;

import com.example.testproject.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_COIN_FILTER = 0;

    private static final String LIST_FRAGMENT_TAG = "LIST_FRAGMENT_TAG";
    private static final String CONVERTER_FRAGMENT_TAG = "CONVERTER_FRAGMENT_TAG";

    private Fragment activeFragment;

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

        activeFragment = Router.openFragment(fragmentManager, activeFragment,
                LIST_FRAGMENT_TAG, R.id.frameСontainer);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.navigationList:
                            textView.setText(R.string.toolbar_currencies_list_title);
                            activeFragment = Router.openFragment(fragmentManager, activeFragment,
                                    LIST_FRAGMENT_TAG, R.id.frameСontainer);
                            return true;

                        case R.id.navigationConverter:
                            textView.setText(R.string.toolbar_converter_title);
                            activeFragment = Router.openFragment(fragmentManager, activeFragment,
                                    CONVERTER_FRAGMENT_TAG, R.id.frameСontainer);
                            return true;
                    }
                    return false;
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        if (requestCode == REQUEST_CODE_COIN_FILTER) {
            Objects.requireNonNull(fragmentManager.findFragmentByTag(LIST_FRAGMENT_TAG))
                    .onActivityResult(requestCode, resultCode, data);
        }
    }
}
