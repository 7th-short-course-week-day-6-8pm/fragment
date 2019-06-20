package com.rathana.fragment_demo.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rathana.fragment_demo.ContactActivity;
import com.rathana.fragment_demo.R;

public class HomeFragment extends Fragment {

    Button btnGo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home_fragment_layout,
                container,false);

        btnGo =view.findViewById(R.id.btnGo);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //bind data to fragment

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Configuration.ORIENTATION_PORTRAIT==
                getActivity().getResources().getConfiguration().orientation){
                    if(getActivity() instanceof ContactActivity){
                        ContactActivity activity=(ContactActivity) getActivity();
                        Fragment fragment=new DetailFragment();
                        activity.replaceFragment(R.id.container,fragment);
                    }
                }

            }
        });

    }
}
