package com.example.jesus.pets.RestApi2.adapter;

import com.example.jesus.pets.RestApi2.ConstantesRestApi;
import com.example.jesus.pets.RestApi2.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by perez on 27/08/2016.
 */
public class RestApiAdapter {
    public Endpoints establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(Endpoints.class);

    }
}
