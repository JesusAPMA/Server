package com.example.jesus.pets.fragment;
import com.google.gson.*;
import android.media.MediaActionSound;
import com.google.gson.JsonElement;
import com.example.jesus.pets.adaptader.MascotaAdaptador;
import com.example.jesus.pets.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jesus on 01/07/2016.
 */
public interface IRecyclerViewFragmentView {

public void generarLinearLayoutVertical();
    public void generarGridLayout();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota>mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
