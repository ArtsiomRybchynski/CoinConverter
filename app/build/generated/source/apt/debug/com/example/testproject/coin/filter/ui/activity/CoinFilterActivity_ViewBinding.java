// Generated code from Butter Knife. Do not modify!
package com.example.testproject.coin.filter.ui.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.testproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CoinFilterActivity_ViewBinding implements Unbinder {
  private CoinFilterActivity target;

  @UiThread
  public CoinFilterActivity_ViewBinding(CoinFilterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CoinFilterActivity_ViewBinding(CoinFilterActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.tbFilterScreen, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.rvFilterList, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CoinFilterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.recyclerView = null;
  }
}
