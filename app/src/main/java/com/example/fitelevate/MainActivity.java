package com.example.fitelevate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    // changed here for fragment
    BottomNavigationView bnView;

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        button=findViewById(R.id.logout);
        textView=findViewById(R.id.user_details);
        bnView=findViewById(R.id.bnView);
        user= auth.getCurrentUser();
        if (user == null){
            Intent intent=new Intent(getApplicationContext(),login.class);
            startActivity(intent);
            finish();
        }else{
            textView.setText(user.getEmail());
        }
        button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(getApplicationContext(),login.class);
            startActivity(intent);
            finish();            });
        bnView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.nav_home){
                   loadfrag(new Home_fragment(),true);

                } else if (id==R.id.nav_activity) {
                   loadfrag(new Activity_fragment(),false);

                } else if (id==R.id.nav_search) {
                 loadfrag(new Search_fragment(),false);

                }else {
                   loadfrag(new Account_fragment(),false);
                }
                return true;
            }
        });
        // we can change the view of selected fragment from here
        bnView.setSelectedItemId(R.id.nav_home);
    }
    //this is the fragment method universal for all fragments of navigation bottom
    public void loadfrag(Fragment fragment,boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        if (flag)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

}