// Generated code from Butter Knife. Do not modify!
package com.example.testproject.coin.detail.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.testproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CoinDetailActivity_ViewBinding implements Unbinder {
  private CoinDetailActivity target;

  @UiThread
  public CoinDetailActivity_ViewBinding(CoinDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CoinDetailActivity_ViewBinding(CoinDetailActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.tbCoinDetailScreen, "field 'toolbar'", Toolbar.class);
    target.ivCoinIcon = Utils.findRequiredViewAsType(source, R.id.ivCoinIcon, "field 'ivCoinIcon'", ImageView.class);
    target.tvCoinName = Utils.findRequiredViewAsType(source, R.id.tvCoinName, "field 'tvCoinName'", TextView.class);
    target.tvCoinFullName = Utils.findRequiredViewAsType(source, R.id.tvCoinFullName, "field 'tvCoinFullName'", TextView.class);
    target.tvCoinAlgorithm = Utils.findRequiredViewAsType(source, R.id.tvCoinAlgorithm, "field 'tvCoinAlgorithm'", TextView.class);
    target.tvCoinPrice = Utils.findRequiredViewAsType(source, R.id.tvCoinPriceUsd, "field 'tvCoinPrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CoinDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.ivCoinIcon = null;
    target.tvCoinName = null;
    target.tvCoinFullName = null;
    target.tvCoinAlgorithm = null;
    target.tvCoinPrice = null;
  }
}
