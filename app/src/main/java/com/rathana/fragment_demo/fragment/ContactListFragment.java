package com.rathana.fragment_demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.rathana.fragment_demo.R;
import com.rathana.fragment_demo.callback.ItemClickCallback;
import com.rathana.fragment_demo.eventbus.Contact;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactListFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> contacts=new ArrayList<>();

    ItemClickCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback=(ItemClickCallback) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_contact_list,
                container,false);

        ButterKnife.bind(this,view);

        initUI(view);

        return view;
    }

    private void initUI(View view){
//        listView=view.findViewById(R.id.listView);
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

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                   //callback.onCallbackWithObject(contacts.get(position));
                    //use event bus
                    EventBus.getDefault().post(new Contact(contacts.get(position)));
                }
            });

    }

    public void setContacts(List<String> contacts){
        this.contacts.addAll(contacts);
    }


}
