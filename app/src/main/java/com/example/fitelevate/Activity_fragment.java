package com.example.fitelevate;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Activity_fragment extends Fragment{

    public CardView card1, card2, card3, card4, card5, card6;
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
        });
        //water intent
        card6.setOnClickListener(view15 -> {
            Intent intent = new Intent(getActivity(), water.class);
            startActivity(intent);
        });
        return view;
    }
}
