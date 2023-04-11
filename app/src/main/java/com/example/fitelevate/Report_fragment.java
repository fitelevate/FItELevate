package com.example.fitelevate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Report_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Report_fragment extends Fragment {

    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

    TextView textViewBmi, textViewBmr, temp;
    SeekBar seekBar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Report_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Report_fragment newInstance(String param1, String param2) {
        Report_fragment fragment = new Report_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_report_fragment, container, false);
        fetchBmi(view);
        fetchBmr(view);
        // Inflate the layout for this fragment

        return view;
    }

    private void fetchBmr(View view) {
        textViewBmr = view.findViewById(R.id.textViewBmr);
        String uid = user.getUid();
        Query checkUser = FirebaseDatabase.getInstance().getReference("bmr").orderByKey().equalTo(uid);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Double bmr = snapshot.child(uid).child("bmrValue").getValue(Double.class);
                    textViewBmr.setText(String.format("%.0f", bmr));
                }
                else{
                    //Toast.makeText(getActivity(), "Snapshot Does Not Exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchBmi(View view) {
        textViewBmi = view.findViewById(R.id.textViewBmi);
        seekBar = view.findViewById(R.id.seekBar);
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        String uid = user.getUid();
        Query checkUser = FirebaseDatabase.getInstance().getReference("bmi").orderByKey().equalTo(uid);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Double bmi = snapshot.child(uid).child("bmiValue").getValue(Double.class);
                    textViewBmi.setText(String.format("%.1f", bmi));
                    int value1 = (int)Math.round(bmi);
                    seekBar.setProgress(value1);
                }
                else{
                    //Toast.makeText(getActivity(), "Snapshot Does Not Exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}