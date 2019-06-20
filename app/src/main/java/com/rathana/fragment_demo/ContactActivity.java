package com.rathana.fragment_demo;

import android.content.res.Configuration;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rathana.fragment_demo.fragment.DetailFragment;
import com.rathana.fragment_demo.fragment.HomeFragment;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Fragment homeFragment=new HomeFragment();
        Fragment detailFragmnet=new DetailFragment();
        if(Configuration.ORIENTATION_PORTRAIT==
                getResources().getConfiguration().orientation){
            addFragment(R.id.container,homeFragment);

        }else if(Configuration.ORIENTATION_LANDSCAPE==
                getResources().getConfiguration().orientation) {

            addFragment(R.id.leftContainer,homeFragment);
            addFragment(R.id.rightContainer,detailFragmnet);
        }

    }

    private void addFragment(@IdRes int container,Fragment fragment){
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        if(fragment!=null){
            t.add(container,fragment);
            t.commit();
        }
    }

    public void replaceFragment(@IdRes int container, Fragment fragment){
        FragmentTransaction t=getSupportFragmentManager().beginTransaction();
        if(fragment!=null){
            t.replace(container,fragment);
            t.addToBackStack(null);
            t.commit();
        }
    }

}
