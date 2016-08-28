package com.example.jesus.pets.restApi;
import com.example.jesus.pets.verificarCuenta;
import com.google.gson.JsonElement;
/**
 * Created by jesus on 04/07/2016.
 */
import com.google.gson.*;
public final class ConstantesRestApi {


//                  OBTENER EL ID DEL PERFIL

   // public static final String ID = verificarCuenta.usuario;

/*
    public static final String VERSION1 = "/v1/";
    public static final String ROOT_URL1 = "https://api.instagram.com" + VERSION1;
    public static final String ACCESS_TOKEN1 = "3498073429.dfdd80e.b134130c9b3442a78d97e99785fc34e4";
    public static final String KEY_ACCESS_TOKEN1= "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_MEDIA_ID1 = "users/search?q="+USER;
    public static final String URL_GET_RECENT_MEDIA_USER1 = KEY_GET_RECENT_MEDIA_MEDIA_ID1 + KEY_ACCESS_TOKEN1 + ACCESS_TOKEN1;
*/


   // https://api.instagram.com/v1/users/search?q=firulais33&access_token=3498073429.dfdd80e.b134130c9b3442a78d97e99785fc34e4



    //                  OBTENER LAS IMAGENES Y DATOS DEL PERFIL
    //https://api.instagram.com/v1/

    public static final String ID="3498073429";
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3498073429.dfdd80e.b134130c9b3442a78d97e99785fc34e4";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_MEDIA_ID = "users/"+ID+"/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_MEDIA_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    // CONSULTA IMAGENES DEL AREA https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
    //CONSULTA UN USUARIO EN ESPECIFICO https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
}




