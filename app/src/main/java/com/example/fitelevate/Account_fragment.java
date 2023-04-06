package com.example.fitelevate;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
 * Use the {@link Account_fragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Account_fragment extends Fragment {

    FirebaseAuth auth;
    Button button;
    TextView textView, userNameInAccount, heightInProfile, ageInProfile, weightInProfile, genderInProfile, mobileInProfile, address;
    FirebaseUser user;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Account_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Account_fragment newInstance(String param1, String param2) {
        Account_fragment fragment = new Account_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Account_fragment() {
        // Required empty public constructor
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

        View view = inflater.inflate(R.layout.fragment_account_fragment, container, false);
        // Inflate the layout for this fragment

        auth=FirebaseAuth.getInstance();
        button=(Button)view.findViewById(R.id.logout);
        textView=(TextView)view.findViewById(R.id.user_details);
        user= auth.getCurrentUser();
        if (user == null){
            Intent intent=new Intent(getActivity(),login.class);
            startActivity(intent);
            getActivity().finish();
        }else{
            textView.setText(user.getEmail());
        }
        fetchUserDetails(view);
        button.setOnClickListener(view1 -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(getActivity(),login.class);
            startActivity(intent);
            getActivity().finish();            });

        return view;
    }

    private void fetchUserDetails(View view) {
        //Hooks
        userNameInAccount = view.findViewById(R.id.userNameInAccount);
        heightInProfile = view.findViewById(R.id.heightInProfile);
        ageInProfile = view.findViewById(R.id.ageInProfile);
        weightInProfile = view.findViewById(R.id.weightInProfile);
        genderInProfile = view.findViewById(R.id.genderInProfile);
        mobileInProfile = view.findViewById(R.id.mobileInProfile);
        address = view.findViewById(R.id.address);

        String uid = user.getUid();
        Query checkUser = FirebaseDatabase.getInstance().getReference("User").orderByKey().equalTo(uid);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String name = snapshot.child(uid).child("name").getValue(String.class);
                    int height = snapshot.child(uid).child("height").getValue(Integer.class);
                    int age = snapshot.child(uid).child("age").getValue(Integer.class);
                    int weight = snapshot.child(uid).child("weight").getValue(Integer.class);
                    String gender = snapshot.child(uid).child("gender").getValue(String.class);
                    Double mobile = snapshot.child(uid).child("mobile").getValue(Double.class);
                    String add = snapshot.child(uid).child("address").getValue(String.class);
                    userNameInAccount.setText(name);
                    heightInProfile.setText(height+" cm");
                    ageInProfile.setText(age+" Years");
                    weightInProfile.setText(weight+" kg");
                    genderInProfile.setText(gender);
                    mobileInProfile.setText(String.format("%.0f", mobile));
                    address.setText(add);
                }
                else{
                    Toast.makeText(getActivity(), "User Details Does Not Exist", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}