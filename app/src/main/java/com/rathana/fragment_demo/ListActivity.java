package com.rathana.fragment_demo;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rathana.fragment_demo.callback.ItemClickCallback;
import com.rathana.fragment_demo.eventbus.Contact;
import com.rathana.fragment_demo.fragment.ContactListFragment;
import com.rathana.fragment_demo.fragment.DetailFragment;
import com.rathana.fragment_demo.utils.FragmentHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity
implements ItemClickCallback {

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

    @Override
    public void onCallbackWithObject(String s) {

        /*Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        DetailFragment detailFragment=new DetailFragment();
        detailFragment.setEmail(s);
        FragmentHelper.replaceFragment(this,R.id.container,detailFragment);
*/


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onContactEvent(Contact contact){
        Toast.makeText(this, contact.getEmail(), Toast.LENGTH_SHORT).show();
        DetailFragment detailFragment=new DetailFragment();
        detailFragment.setEmail(contact.getEmail());
        FragmentHelper.replaceFragment(this,R.id.container,detailFragment);
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
