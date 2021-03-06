// Generated code from Butter Knife. Do not modify!
package com.example.testproject.presentation.ui.activities;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.testproject.R;
import com.example.testproject.coin.list.ui.activitiy.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.bottomNavigationView = Utils.findRequiredViewAsType(source, R.id.bottomNavigationView, "field 'bottomNavigationView'", BottomNavigationView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.tbMainScreen, "field 'toolbar'", Toolbar.class);
    target.textView = Utils.findRequiredViewAsType(source, R.id.tbTitle, "field 'textView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.bottomNavigationView = null;
    target.toolbar = null;
    target.textView = null;
  }
}
