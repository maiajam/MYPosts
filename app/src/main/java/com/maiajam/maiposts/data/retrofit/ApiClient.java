package com.maiajam.maiposts.data.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String baseUrl = "https://jsonplaceholder.typicode.com/";
    public static Retrofit retrofit = null ;


    public Retrofit ApiClient() {
        if(retrofit == null)
        retrofit =  new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();

        return retrofit ;
    }

}
