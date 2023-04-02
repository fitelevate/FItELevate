package com.example.fitelevate;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Home_fragment extends Fragment {
    private Button bmiBtn, bmrBtn, yogaBtn, walkBtn, exerciseBtn, waterBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        bmiBtn = view.findViewById(R.id.bmibtn);
        bmrBtn = view.findViewById(R.id.bmrbtn);
        yogaBtn = view.findViewById(R.id.yogabtn);
        walkBtn = view.findViewById(R.id.walkbtn);
        exerciseBtn = view.findViewById(R.id.exebtn);
        waterBtn = view.findViewById(R.id.waterbtn);

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
                // Handle BMR button click
                Intent intent = new Intent(getActivity(), bmr.class);
                startActivity(intent);
            }
        });

        yogaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle yoga button click
                Intent intent = new Intent(getActivity(), yoga.class);
                startActivity(intent);
            }
        });

        walkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle walk button click
                Intent intent = new Intent(getActivity(), step_counter.class);
                startActivity(intent);
            }
        });

        exerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle exercise button click
                Intent intent = new Intent(getActivity(), exercise.class);
                startActivity(intent);
            }
        });

        waterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle water button click
                Intent intent = new Intent(getActivity(), water.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
