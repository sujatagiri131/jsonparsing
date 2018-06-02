package com.android.jsontraining;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClitent {
    public static Retrofit retrofit = null;
    public static Retrofit getRetrofit(){
             if(retrofit == null){
                 retrofit =new Retrofit.Builder()
                         .baseUrl("http://vedisapp.berlin-webdesign-agentur.de/")
                         .addConverterFactory(GsonConverterFactory.create())//convert json data to gson
                         .build();
             }
        return  retrofit;
    }

}