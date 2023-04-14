package com.example.fitelevate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Home_fragment extends Fragment {
//    private Button  walkBtn, exerciseBtn, waterBtn, nutritionBtn;
    private ImageView bmiBtn, bmrBtn, yogaBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        bmiBtn = view.findViewById(R.id.bmibtn);
        bmrBtn = view.findViewById(R.id.bmrbtn);
        yogaBtn = view.findViewById(R.id.yogabtn);
//        walkBtn = view.findViewById(R.id.walkbtn);
//        exerciseBtn = view.findViewById(R.id.exebtn);
//        waterBtn = view.findViewById(R.id.waterbtn);
//        nutritionBtn = view.findViewById(R.id.nutritionbtn);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean hasInputData = sharedPreferences.getBoolean("hasInputData", false);

        // Set click listeners for each button
        bmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bmi.class);
                startActivity(intent);
            }
        });

        bmrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bmr.class);
                startActivity(intent);
            }
        });

        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), yoga.class);
                startActivity(intent);
            }
        });

//        walkBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), step_counter.class);
//                startActivity(intent);
//            }
//        });

//        nutritionBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle water button click
//                Intent intent = new Intent(getActivity(), nutrition.class);
//                startActivity(intent);
//            }
//        });

//        exerciseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), exercise.class);
//                startActivity(intent);
//            }
//        });

//        waterBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (hasInputData) {
//                    Intent intent = new Intent(getActivity(), WaterMainActivity.class);
//                    startActivity(intent);
//                } else {
//                    Intent intent = new Intent(getActivity(), WaterActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });

//        nutritionBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), nutrition.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }


}
