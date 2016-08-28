package com.example.jesus.pets;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by perez on 22/08/2016.
 */
public class NotificacionIdTokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {


        String token = FirebaseInstanceId.getInstance().getToken();
enviarTokenRegistro(token);



    }
    private void enviarTokenRegistro(String token){

        Log.d("TOKEN", token);

    }
}
