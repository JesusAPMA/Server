package com.example.jesus.pets.restApi.deserializador;

import com.example.jesus.pets.pojo.Mascota;
import com.example.jesus.pets.restApi.jsonKeys;
import com.example.jesus.pets.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.JsonElement;
/**
 * Created by jesus on 05/07/2016.
 */
public class MascotaDeserializador implements JsonDeserializer <MascotaResponse>{


    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson= new Gson();
        MascotaResponse mascotaResponse=gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData= json.getAsJsonObject().getAsJsonArray(jsonKeys.MEDIA_RESPONSE_ARRAY);
        mascotaResponse.setMascotas(deserializarMascotaDeJson(mascotaResponseData));
        return mascotaResponse;
    }
    private ArrayList<Mascota> deserializarMascotaDeJson(JsonArray mascotaResponseData){
        
        ArrayList<Mascota> mascotas=new ArrayList<>();
        for (int i = 0; i <mascotaResponseData.size() ; i++) {
            JsonObject mascotaResponseDataObject    = mascotaResponseData.get(i).getAsJsonObject();
            JsonObject userJson                     = mascotaResponseDataObject.getAsJsonObject(jsonKeys.USER);
            String id                               = userJson.get(jsonKeys.USER_ID).getAsString();
            String nombreCompleto                   = userJson.get(jsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson                    = mascotaResponseDataObject.getAsJsonObject(jsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson            = imageJson.getAsJsonObject(jsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                          = stdResolutionJson.get(jsonKeys.MEDIA_URL).getAsString();

            JsonObject likeJson                     = mascotaResponseDataObject.getAsJsonObject(jsonKeys.MEDIA_LIKES);
            int likes                               = likeJson.get(jsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Mascota mascotaActual= new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setNombreCompleto(nombreCompleto);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setLikes(likes);

             mascotas.add(mascotaActual);

        }
        return mascotas;
    }
}
