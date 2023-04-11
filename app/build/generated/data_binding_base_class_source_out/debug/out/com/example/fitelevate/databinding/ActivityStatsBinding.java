// Generated by view binder compiler. Do not edit!
package com.example.fitelevate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fitelevate.R;
import com.github.mikephil.charting.charts.LineChart;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import me.itangqi.waveloadingview.WaveLoadingView;

public final class ActivityStatsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnBack;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final LineChart chart;

  @NonNull
  public final LinearLayout linearLayout7;

  @NonNull
  public final LinearLayout linearLayout8;

  @NonNull
  public final TextView remainingIntake;

  @NonNull
  public final TextView targetIntake;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView14;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final WaveLoadingView waterLevelView;

  private ActivityStatsBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton btnBack,
      @NonNull CardView cardView2, @NonNull LineChart chart, @NonNull LinearLayout linearLayout7,
      @NonNull LinearLayout linearLayout8, @NonNull TextView remainingIntake,
      @NonNull TextView targetIntake, @NonNull TextView textView10, @NonNull TextView textView12,
      @NonNull TextView textView14, @NonNull TextView textView8,
      @NonNull WaveLoadingView waterLevelView) {
    this.rootView = rootView;
    this.btnBack = btnBack;
    this.cardView2 = cardView2;
    this.chart = chart;
    this.linearLayout7 = linearLayout7;
    this.linearLayout8 = linearLayout8;
    this.remainingIntake = remainingIntake;
    this.targetIntake = targetIntake;
    this.textView10 = textView10;
    this.textView12 = textView12;
    this.textView14 = textView14;
    this.textView8 = textView8;
    this.waterLevelView = waterLevelView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStatsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStatsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_stats, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStatsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBack;
      ImageButton btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.cardView2;
      CardView cardView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardView2 == null) {
        break missingId;
      }

      id = R.id.chart;
      LineChart chart = ViewBindings.findChildViewById(rootView, id);
      if (chart == null) {
        break missingId;
      }

      id = R.id.linearLayout7;
      LinearLayout linearLayout7 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout7 == null) {
        break missingId;
      }

      id = R.id.linearLayout8;
      LinearLayout linearLayout8 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout8 == null) {
        break missingId;
      }

      id = R.id.remainingIntake;
      TextView remainingIntake = ViewBindings.findChildViewById(rootView, id);
      if (remainingIntake == null) {
        break missingId;
      }

      id = R.id.targetIntake;
      TextView targetIntake = ViewBindings.findChildViewById(rootView, id);
      if (targetIntake == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView14;
      TextView textView14 = ViewBindings.findChildViewById(rootView, id);
      if (textView14 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.waterLevelView;
      WaveLoadingView waterLevelView = ViewBindings.findChildViewById(rootView, id);
      if (waterLevelView == null) {
        break missingId;
      }

      return new ActivityStatsBinding((ConstraintLayout) rootView, btnBack, cardView2, chart,
          linearLayout7, linearLayout8, remainingIntake, targetIntake, textView10, textView12,
          textView14, textView8, waterLevelView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
