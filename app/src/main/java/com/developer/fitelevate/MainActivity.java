package com.developer.fitelevate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    // changed here for fragment
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView=findViewById(R.id.bnView);
        bnView.setOnItemSelectedListener(item -> {
            int id=item.getItemId();
            if(id==R.id.nav_home){
               loadfrag(new Home_fragment(),true);

            } else if (id==R.id.nav_activity) {
               loadfrag(new Activity_fragment(),false);

            } else if (id==R.id.nav_search) {
             loadfrag(new Report_fragment(),false);

            }else {
               loadfrag(new Account_fragment(),false);
            }
            return true;
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