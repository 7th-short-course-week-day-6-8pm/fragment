package com.rathana.fragment_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rathana.fragment_demo.R;

public class DetailFragment extends Fragment {

    private String email ;
    TextView tvEmail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.detail_fragment_layout,
                container,false);

        tvEmail= view.findViewById(R.id.result);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //bind data to fragment

        tvEmail.setText(email==null ? "":email);

    }

    public void setEmail(String email){
        this.email=email;
    }
}
