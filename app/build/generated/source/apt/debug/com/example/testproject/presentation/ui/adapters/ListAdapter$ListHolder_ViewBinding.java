// Generated code from Butter Knife. Do not modify!
package com.example.testproject.presentation.ui.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.testproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListAdapter$ListHolder_ViewBinding implements Unbinder {
  private ListAdapter.ListHolder target;

  @UiThread
  public ListAdapter$ListHolder_ViewBinding(ListAdapter.ListHolder target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.ivCurrencyIcon, "field 'imageView'", ImageView.class);
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tvCurrencyName, "field 'tvName'", TextView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tvCurrencyPrice, "field 'tvPrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListAdapter.ListHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageView = null;
    target.tvName = null;
    target.tvPrice = null;
  }
}
