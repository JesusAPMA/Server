package com.example.jesus.pets.pojo;
import com.google.gson.JsonElement;
import com.google.gson.*;
/**
 * Created by jesus on 27/06/2016.
 */
public class Mascota {
    private String id;
    private String nombreCompleto;
    //private String tipo;
    private int likes = 0;
    private String urlFoto;

    public Mascota(String urlFoto, String nombreCompleto, int likes) {
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
        this.urlFoto = urlFoto;
    }

    public Mascota() {

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}