package com.myapp.newsapplication.serverdao;


public class ApiUtils {

    private static String url = "http://newsapi.org/v2/";

    public static APIService getApiServices() {
        return RetrofitClient.getClient_new(url).create(APIService.class);
    }

}
