// Generated by view binder compiler. Do not edit!
package com.example.fitelevate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fitelevate.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText email;

  @NonNull
  public final TextView forgotPass;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final AppCompatButton loginWithGoogle;

  @NonNull
  public final TextView passLoginFromSignup;

  @NonNull
  public final EditText passwd;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final Button submitButton;

  @NonNull
  public final TextView textView6;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView, @NonNull EditText email,
      @NonNull TextView forgotPass, @NonNull ImageView imageView2, @NonNull ImageView imageView3,
      @NonNull AppCompatButton loginWithGoogle, @NonNull TextView passLoginFromSignup,
      @NonNull EditText passwd, @NonNull ProgressBar progressBar, @NonNull Button submitButton,
      @NonNull TextView textView6) {
    this.rootView = rootView;
    this.email = email;
    this.forgotPass = forgotPass;
    this.imageView2 = imageView2;
    this.imageView3 = imageView3;
    this.loginWithGoogle = loginWithGoogle;
    this.passLoginFromSignup = passLoginFromSignup;
    this.passwd = passwd;
    this.progressBar = progressBar;
    this.submitButton = submitButton;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.forgot_pass;
      TextView forgotPass = ViewBindings.findChildViewById(rootView, id);
      if (forgotPass == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.login_with_google;
      AppCompatButton loginWithGoogle = ViewBindings.findChildViewById(rootView, id);
      if (loginWithGoogle == null) {
        break missingId;
      }

      id = R.id.pass_login_from_signup;
      TextView passLoginFromSignup = ViewBindings.findChildViewById(rootView, id);
      if (passLoginFromSignup == null) {
        break missingId;
      }

      id = R.id.passwd;
      EditText passwd = ViewBindings.findChildViewById(rootView, id);
      if (passwd == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.submitButton;
      Button submitButton = ViewBindings.findChildViewById(rootView, id);
      if (submitButton == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, email, forgotPass, imageView2,
          imageView3, loginWithGoogle, passLoginFromSignup, passwd, progressBar, submitButton,
          textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
