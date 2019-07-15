package com.afimakarim.formisianuas2019.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    public static  ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("localhost:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        return service;
    }
}
