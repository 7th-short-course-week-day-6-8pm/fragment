package com.rathana.fragment_demo;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rathana.fragment_demo.fragment.ContactListFragment;
import com.rathana.fragment_demo.utils.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    List<String> contacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        for(int i=0;i<50;i++){
            this.contacts.add("admin"+i+"@gmail.com");
        }

        ContactListFragment contactListFragment=new ContactListFragment();
        contactListFragment.setContacts(contacts);

        FragmentHelper.addFragment(this,R.id.container,contactListFragment);
    }



}
