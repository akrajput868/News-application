package com.myapp.newsapplication.serverdao;

import com.myapp.newsapplication.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("top-headlines")
    Call<News> getNews(@Query("country") String country,
                       @Query("apiKey") String apiKey);

}


