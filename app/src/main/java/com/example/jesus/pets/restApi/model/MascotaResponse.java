package com.example.jesus.pets.restApi.model;
import com.google.gson.*;
import com.example.jesus.pets.pojo.Mascota;
import com.google.gson.JsonElement;
import java.util.ArrayList;

/**
 * Created by jesus on 04/07/2016.
 */
public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
