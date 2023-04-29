package com.developer.fitelevate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Activity_fragment extends Fragment{

    private boolean permissionAlreadyGranted = false;
    private boolean permissionAlreadyDenied = false;
  //  private SharedPreferences sharedPreferences; // declare shared preferences

    String[] permissions = {"android.permission.ACTIVITY_RECOGNITION"};

    public CardView card1, card2, card3, card4, card5, card6,card7;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_activity_fragment, container, false);
        card1=(CardView)view.findViewById(R.id.cardbmi);
        card2=(CardView)view.findViewById(R.id.cardbmr);
        card3=(CardView)view.findViewById(R.id.cardyoga);
        card4=(CardView)view.findViewById(R.id.cardexercise);
        card5=(CardView)view.findViewById(R.id.cardstep);
        card6=(CardView)view.findViewById(R.id.cardwater);
        card7=(CardView)view.findViewById(R.id.cardNutrition);

   //     sharedPreferences = getActivity().getSharedPreferences("WaterData", getActivity().MODE_PRIVATE); // initialize shared preferences

        //bmi intent
        card1.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), bmi.class);
            startActivity(intent);
        });

        //bmr intent

        card2.setOnClickListener(view16 -> {
            Intent intent = new Intent(getActivity(), bmr.class);
            startActivity(intent);
        });

        //yoga intent

        card3.setOnClickListener(view12 -> {
            Intent intent = new Intent(getActivity(), yoga.class);
            startActivity(intent);
        });

        //exercise intent

        card4.setOnClickListener(view13 -> {
            Intent intent = new Intent(getActivity(), exercise.class);
            startActivity(intent);
        });

        //step intent

        card5.setOnClickListener(view14 -> {
            Intent intent = new Intent(getActivity(), step_counter.class);
            startActivity(intent);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(permissions, 80);
            }
        });

        //water intent
        card6.setOnClickListener(view15 -> {
            // check if user has input data for WaterActivity
          //  if (sharedPreferences.getBoolean("hasInputData", false)) {
            //    Intent intent = new Intent(getActivity(), WaterMainActivity.class);
              //  startActivity(intent);
        //    } else {
               Intent intent = new Intent(getActivity(), WaterActivity.class);
               startActivity(intent);
          //  }
        });

        // nutrition intent
        card7.setOnClickListener(view17 -> {
            Intent intent = new Intent(getActivity(), nutrition.class);
            startActivity(intent);
        });

        return view;
    }

   /* @Override
    public void onPause() {
        super.onPause();
        // save if user has input data for WaterActivity in shared preferences
        sharedPreferences.edit().putBoolean("hasInputData", true).apply();
    }*/
}
