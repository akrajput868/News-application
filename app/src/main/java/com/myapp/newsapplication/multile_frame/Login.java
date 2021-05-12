package com.myapp.newsapplication.multile_frame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.myapp.newsapplication.R;


public class Login extends Fragment {

    EditText mail,password;
    Button login,logout;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Login() {
        // Required empty public constructor
    }


    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
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
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        mail=(EditText) view.findViewById(R.id.mail);
        password=(EditText) view.findViewById(R.id.password);
        login=(Button) view.findViewById(R.id.login);
        logout=(Button) view.findViewById(R.id.logout);

        return view;
    }
}