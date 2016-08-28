package com.example.jesus.pets.RestApi2;

import com.example.jesus.pets.RestApi2.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by perez on 27/08/2016.
 */
public interface Endpoints {
    @FormUrlEncoded()
    @POST (ConstantesRestApi.KEY_POST_ID_TOKEN)
Call<UsuarioResponse> registrarTokenID(@Field("token")String token);


}
