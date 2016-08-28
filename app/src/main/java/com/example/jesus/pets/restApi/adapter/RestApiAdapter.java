package com.example.jesus.pets.restApi.adapter;

import com.example.jesus.pets.restApi.ConstantesRestApi;
import com.example.jesus.pets.restApi.EndpointsApi;
import com.example.jesus.pets.restApi.deserializador.MascotaDeserializador;
import com.example.jesus.pets.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.*;
/**
 * Created by jesus on 05/07/2016.
 */
public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);

    }



    public Gson construyeGsonDeserializadorDeMediaRecent() {
        GsonBuilder gsonBuilder= new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return  gsonBuilder.create();



    }
}
