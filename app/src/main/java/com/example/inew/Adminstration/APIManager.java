package com.example.inew.Adminstration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

     static Retrofit getRetrofitInstance(){

        return retrofit;
    }

    public static NewService getService(){
        return retrofit.create(NewService.class);
    }

}
