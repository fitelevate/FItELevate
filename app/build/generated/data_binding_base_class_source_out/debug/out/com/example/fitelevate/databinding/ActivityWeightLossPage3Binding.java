// Generated by view binder compiler. Do not edit!
package com.example.fitelevate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fitelevate.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWeightLossPage3Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TableLayout BeforeBedChart;

  @NonNull
  public final TableLayout dinnerChart;

  private ActivityWeightLossPage3Binding(@NonNull RelativeLayout rootView,
      @NonNull TableLayout BeforeBedChart, @NonNull TableLayout dinnerChart) {
    this.rootView = rootView;
    this.BeforeBedChart = BeforeBedChart;
    this.dinnerChart = dinnerChart;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWeightLossPage3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWeightLossPage3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_weight_loss_page3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWeightLossPage3Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Before_bed_chart;
      TableLayout BeforeBedChart = ViewBindings.findChildViewById(rootView, id);
      if (BeforeBedChart == null) {
        break missingId;
      }

      id = R.id.dinner_chart;
      TableLayout dinnerChart = ViewBindings.findChildViewById(rootView, id);
      if (dinnerChart == null) {
        break missingId;
      }

      return new ActivityWeightLossPage3Binding((RelativeLayout) rootView, BeforeBedChart,
          dinnerChart);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
