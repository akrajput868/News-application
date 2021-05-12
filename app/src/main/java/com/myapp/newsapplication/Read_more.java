package com.myapp.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Read_more extends AppCompatActivity {

    WebView web;
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);
        getSupportActionBar().hide();

            pDialog = new ProgressDialog(Read_more.this);
            pDialog.setMessage("Loading...");
            pDialog.show();
            web=(WebView) findViewById(R.id.web);
            web.getSettings().setJavaScriptEnabled(true);
            web.loadUrl(getIntent().getStringExtra("URL"));

    }
}