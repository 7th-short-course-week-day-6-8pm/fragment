package com.rathana.fragment_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rathana.fragment_demo.fragment.DetailFragment;
import com.rathana.fragment_demo.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    static  final String HOME_FRAGMENT_TAG="HOME_FRAGMENT";
    static  final String DETAIL_FRAGMENT_TAG="DETAIL_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();

        //create fragment object
        HomeFragment homeFragment=new HomeFragment();
        transaction.add(R.id.container,homeFragment,HOME_FRAGMENT_TAG);
        transaction.commit();
    }

    public void onReplaceFragment(View view){

        FragmentTransaction t =getSupportFragmentManager().beginTransaction();

        Fragment fragment=getSupportFragmentManager().findFragmentByTag(DETAIL_FRAGMENT_TAG);

         if(fragment==null)
            fragment= new DetailFragment();
        t.replace(R.id.container,fragment,DETAIL_FRAGMENT_TAG);
        t.addToBackStack(null);
        t.commit();
    }

    private void findFragment(){

    }

}
