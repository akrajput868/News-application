package com.myapp.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login_activity extends AppCompatActivity {

    EditText name,phone,mail,address,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Registation");
        setContentView(R.layout.activity_login_activity);
        name=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.phone);
        mail=(EditText) findViewById(R.id.mail);
        address=(EditText) findViewById(R.id.address);
        password=(EditText) findViewById(R.id.password);
    }
}