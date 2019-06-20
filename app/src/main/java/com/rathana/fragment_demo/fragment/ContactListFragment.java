package com.rathana.fragment_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rathana.fragment_demo.R;

import java.util.ArrayList;
import java.util.List;

public class ContactListFragment extends Fragment {


    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> contacts=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_contact_list,
                container,false);

        initUI(view);

        return view;
    }

    private void initUI(View view){
        listView=view.findViewById(R.id.listView);
        adapter=new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                contacts
                );
        listView.setAdapter(adapter);
    }

    @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);


            adapter.notifyDataSetChanged();

    }

    public void setContacts(List<String> contacts){
        this.contacts.addAll(contacts);
    }
}
