// Generated code from Butter Knife. Do not modify!
package com.example.testproject.coin.converter.ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.testproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConverterFragment_ViewBinding implements Unbinder {
  private ConverterFragment target;

  @UiThread
  public ConverterFragment_ViewBinding(ConverterFragment target, View source) {
    this.target = target;

    target.editText = Utils.findRequiredViewAsType(source, R.id.etInValue, "field 'editText'", EditText.class);
    target.ivInCurrency = Utils.findRequiredViewAsType(source, R.id.ivInCurrency, "field 'ivInCurrency'", ImageView.class);
    target.tvConvertingValue = Utils.findRequiredViewAsType(source, R.id.tvConvertingValue, "field 'tvConvertingValue'", TextView.class);
    target.ivConverting = Utils.findRequiredViewAsType(source, R.id.ivConverting, "field 'ivConverting'", ImageView.class);
    target.tvConvertingResult = Utils.findRequiredViewAsType(source, R.id.tvConvertingResult, "field 'tvConvertingResult'", TextView.class);
    target.ivOutCurrency = Utils.findRequiredViewAsType(source, R.id.ivOutCurrency, "field 'ivOutCurrency'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConverterFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editText = null;
    target.ivInCurrency = null;
    target.tvConvertingValue = null;
    target.ivConverting = null;
    target.tvConvertingResult = null;
    target.ivOutCurrency = null;
  }
}
