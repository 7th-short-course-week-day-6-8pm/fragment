package com.rathana.fragment_demo.utils;

import android.content.Context;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class FragmentHelper {

    public static void addFragment(AppCompatActivity activity, @IdRes int container,
                                   Fragment fragment){
        if(fragment!=null){
            FragmentTransaction t = activity.getSupportFragmentManager().beginTransaction();
            t.add(container,fragment);
            t.commit();
        }

    }


    public static void replaceFragment(AppCompatActivity activity,
                                       @IdRes int container,
                                       Fragment fragment){

        if(fragment!=null){
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(container,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
