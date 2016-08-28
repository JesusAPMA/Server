package com.example.jesus.pets.restApi;
import com.google.gson.*;
import com.example.jesus.pets.pojo.Mascota;
import com.example.jesus.pets.restApi.model.MascotaResponse;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jesus on 04/07/2016.
 */
public interface EndpointsApi {


    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

}
