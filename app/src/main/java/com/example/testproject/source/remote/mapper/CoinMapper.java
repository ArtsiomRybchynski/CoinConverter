package com.example.testproject.source.remote.mapper;

import com.example.testproject.entity.coin.Coin;
import com.example.testproject.entity.coin.CoinDescription;
import com.example.testproject.entity.RawResponse;

import java.util.List;

import io.reactivex.functions.Function;

public class CoinMapper<T extends RawResponse, V extends List<Coin>> implements Function<T, V> {

    private V coins;

    public CoinMapper(V coins) {
        this.coins = coins;
    }

    @Override
    public V apply(T t) {

        List<CoinDescription> coinDescriptions = t.getCoinDescriptions();
        Coin coin;

        for (CoinDescription coinDescription : coinDescriptions) {
            coin = coinDescription.getCoin();
            coin.setPrice(coinDescription.getCurrencies()
                    .getUsdCurrency()
                    .getPrice()
            );

            coin.setImageUrl(Coin.BASE_IMAGE_URL.concat(coin.getImageUrl()));
            coins.add(coin);

        }
        return coins;
    }
}
