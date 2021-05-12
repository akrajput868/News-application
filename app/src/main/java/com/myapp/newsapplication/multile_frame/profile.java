package com.myapp.newsapplication.multile_frame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapp.newsapplication.R;


public class profile extends Fragment {

    TextView name,mail,phone,address;
    ImageView dp;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public profile() {
        // Required empty public constructor
    }


    public static profile newInstance(String param1, String param2) {
        profile fragment = new profile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        name=(TextView) view.findViewById(R.id.name);
        mail=(TextView) view.findViewById(R.id.mail);
        phone=(TextView) view.findViewById(R.id.phone);
        address=(TextView) view.findViewById(R.id.address);
        dp=(ImageView) view.findViewById(R.id.dp);

        return view;
    }
}