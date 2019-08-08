package com.rapidvaluetest.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.NetworkInterface;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    private static final String BASE_URL = "https://pixabay.com/api/";
    private static Retrofit retrofit;


    /*private static Retrofit getRetroInstance(){

        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }


    public static ApiServices getApiService(){
       // return getRetroInstance().create(ApiServices.class);
        return getRetroInstance().create(ApiServices.class);
    }*/


    public static Retrofit getRetrofit(){

        if(retrofit==null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

        }

        return retrofit;
    }

}
