// Generated code from Butter Knife. Do not modify!
package com.example.testproject.presentation.ui.fragments;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.testproject.R;
import com.example.testproject.coin.list.ui.fragment.ListFragment;

import java.lang.IllegalStateException;
import java.lang.Override;

public class ListFragment_ViewBinding implements Unbinder {
  private ListFragment target;

  @UiThread
  public ListFragment_ViewBinding(ListFragment target, View source) {
    this.target = target;

    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progressBarList, "field 'progressBar'", ProgressBar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerViewList, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.progressBar = null;
    target.recyclerView = null;
  }
}
