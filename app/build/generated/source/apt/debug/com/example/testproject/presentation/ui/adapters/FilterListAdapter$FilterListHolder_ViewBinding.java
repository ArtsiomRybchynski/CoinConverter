// Generated code from Butter Knife. Do not modify!
package com.example.testproject.presentation.ui.adapters;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.testproject.R;
import com.example.testproject.coin.filter.ui.adapter.FilterListAdapter;

import java.lang.IllegalStateException;
import java.lang.Override;

public class FilterListAdapter$FilterListHolder_ViewBinding implements Unbinder {
  private FilterListAdapter.FilterListHolder target;

  @UiThread
  public FilterListAdapter$FilterListHolder_ViewBinding(FilterListAdapter.FilterListHolder target,
      View source) {
    this.target = target;

    target.ivCoinIcon = Utils.findRequiredViewAsType(source, R.id.ivCoinIconFilter, "field 'ivCoinIcon'", ImageView.class);
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tvCoinNameFilter, "field 'tvName'", TextView.class);
    target.checkBox = Utils.findRequiredViewAsType(source, R.id.checkBoxFilter, "field 'checkBox'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FilterListAdapter.FilterListHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivCoinIcon = null;
    target.tvName = null;
    target.checkBox = null;
  }
}
