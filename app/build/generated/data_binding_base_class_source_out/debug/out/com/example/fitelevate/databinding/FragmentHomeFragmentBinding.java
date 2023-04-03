// Generated by view binder compiler. Do not edit!
package com.example.fitelevate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fitelevate.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeFragmentBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button bmibtn;

  @NonNull
  public final Button bmrbtn;

  @NonNull
  public final Button exebtn;

  @NonNull
  public final Button walkbtn;

  @NonNull
  public final Button waterbtn;

  @NonNull
  public final Button yogabtn;

  private FragmentHomeFragmentBinding(@NonNull FrameLayout rootView, @NonNull Button bmibtn,
      @NonNull Button bmrbtn, @NonNull Button exebtn, @NonNull Button walkbtn,
      @NonNull Button waterbtn, @NonNull Button yogabtn) {
    this.rootView = rootView;
    this.bmibtn = bmibtn;
    this.bmrbtn = bmrbtn;
    this.exebtn = exebtn;
    this.walkbtn = walkbtn;
    this.waterbtn = waterbtn;
    this.yogabtn = yogabtn;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bmibtn;
      Button bmibtn = ViewBindings.findChildViewById(rootView, id);
      if (bmibtn == null) {
        break missingId;
      }

      id = R.id.bmrbtn;
      Button bmrbtn = ViewBindings.findChildViewById(rootView, id);
      if (bmrbtn == null) {
        break missingId;
      }

      id = R.id.exebtn;
      Button exebtn = ViewBindings.findChildViewById(rootView, id);
      if (exebtn == null) {
        break missingId;
      }

      id = R.id.walkbtn;
      Button walkbtn = ViewBindings.findChildViewById(rootView, id);
      if (walkbtn == null) {
        break missingId;
      }

      id = R.id.waterbtn;
      Button waterbtn = ViewBindings.findChildViewById(rootView, id);
      if (waterbtn == null) {
        break missingId;
      }

      id = R.id.yogabtn;
      Button yogabtn = ViewBindings.findChildViewById(rootView, id);
      if (yogabtn == null) {
        break missingId;
      }

      return new FragmentHomeFragmentBinding((FrameLayout) rootView, bmibtn, bmrbtn, exebtn,
          walkbtn, waterbtn, yogabtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
