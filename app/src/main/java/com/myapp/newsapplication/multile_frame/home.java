package com.myapp.newsapplication.multile_frame;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myapp.newsapplication.MainActivity;
import com.myapp.newsapplication.News;
import com.myapp.newsapplication.R;
import com.myapp.newsapplication.Read_more;
import com.myapp.newsapplication.adapterclass;
import com.myapp.newsapplication.serverdao.APIService;
import com.myapp.newsapplication.serverdao.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class home extends Fragment implements adapterclass.onClick {

    private List<News.Article> listNews = new ArrayList<>();
    ProgressDialog pDialog;
    private APIService apiUtil;
    private RecyclerView list;
    private adapterclass adapter;

    public home() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);


        list = (RecyclerView) view.findViewById(R.id.res1);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        apiUtil = ApiUtils.getApiServices();

        getDataFromServer();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(linearLayoutManager);
    }

    private void getDataFromServer(){
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        listNews.clear();
        Call<News> call = apiUtil.getNews("IN", "21a484d65dbf4bb986558ad0cb96a625");

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                try {
                    pDialog.dismiss();
                    if (response != null) {
                        News st = response.body();
                        if (st.getStatus()!= null && st.getStatus().equals("ok")) {
                            listNews.addAll(st.getArticles());
                            setData();
                            Toast.makeText(getActivity(), ""+listNews.size(), Toast.LENGTH_LONG).show();
                        } else {
                            //Util.showDialogWarning(getActivity(), "Data Not Fetch, please try again!");
                        }
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }

    private void setData(){
        adapter = new adapterclass(getActivity(), listNews, this);
        list.setAdapter(adapter);
    }

    @Override
    public void itemClick(News.Article item) {
        Intent in = new Intent(getActivity(), Read_more.class);
        in.putExtra("URL", item.getUrl());
        startActivity(in);
    }

}