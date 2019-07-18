package com.example.testproject.coin.converter.ui.fragment;


import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testproject.App;
import com.example.testproject.GlideApp;
import com.example.testproject.R;
import com.example.testproject.coin.converter.presenter.ConverterPresenter;
import com.example.testproject.coin.converter.presenter.impl.ConverterPresenterImpl;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConverterFragment extends Fragment implements ConverterPresenter.ConverterView {

    private static final String USD_CURRENCY_NAME = "USD";
    private static final String EUR_CURRENCY_NAME = "EUR";
    private static final String RUB_CURRENCY_NAME = "RUB";
    private static final String BYN_CURRENCY_NAME = "BYN";

    @BindView(R.id.etInValue)
    EditText editText;

    @BindView(R.id.ivInCurrency)
    ImageView ivInCurrency;

    @BindView(R.id.tvConvertingValue)
    TextView tvConvertingValue;

    @BindView(R.id.ivConverting)
    ImageView ivConverting;

    @BindView(R.id.tvConvertingResult)
    TextView tvConvertingResult;

    @BindView(R.id.ivOutCurrency)
    ImageView ivOutCurrency;

    private ConverterPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_converter, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new ConverterPresenterImpl(App.getRepository());
        presenter.onAttach(this);
        presenter.requestSinglePrice();
        presenter.getAllCoins();

        ivConverting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.reverse();
            }
        });
    }

    @Override
    public void showSinglePrice(String coinName, String price, String currency) {
        Resources res = getResources();

        tvConvertingValue.setText(
                String.format(res.getString(R.string.converting_value), coinName, price, currency)
        );
    }

    @Override
    public void showInCurrencyIcon(String source, boolean coinToCurrency) {
        if (coinToCurrency) {
            GlideApp.with(this)
                    .load(source)
                    .into(ivInCurrency);
        } else {
            Resources res = getResources();
            switch (source) {
                case USD_CURRENCY_NAME:
                    ivInCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_dollar));
                    break;

                case EUR_CURRENCY_NAME:
                    ivInCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_euro));
                    break;

                case RUB_CURRENCY_NAME:
                    ivInCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_ruble));
                    break;

                case BYN_CURRENCY_NAME:
                    ivInCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_belruble));
                    break;
            }
        }
    }

    @Override
    public void showOutCurrencyIcon(String source, boolean coinToCurrency) {
        if (coinToCurrency) {
            Resources res = getResources();
            switch (source) {
                case USD_CURRENCY_NAME:
                    ivOutCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_dollar));
                    break;

                case EUR_CURRENCY_NAME:
                    ivOutCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_euro));
                    break;

                case RUB_CURRENCY_NAME:
                    ivOutCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_ruble));
                    break;

                case BYN_CURRENCY_NAME:
                    ivOutCurrency.setImageDrawable(res.getDrawable(R.drawable.ic_belruble));
                    break;
            }
        } else {
            GlideApp.with(this)
                    .load(source)
                    .into(ivOutCurrency);
        }

    }

    @Override
    public void updateView() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
