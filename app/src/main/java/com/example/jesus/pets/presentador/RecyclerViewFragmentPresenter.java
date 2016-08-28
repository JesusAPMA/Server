package com.example.jesus.pets.presentador;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.JsonElement;
import com.example.jesus.pets.db.ConstructorMascotas;
import com.example.jesus.pets.fragment.IRecyclerViewFragmentView;
import com.example.jesus.pets.pojo.Mascota;
import com.example.jesus.pets.restApi.EndpointsApi;
import com.example.jesus.pets.restApi.adapter.RestApiAdapter;
import com.example.jesus.pets.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jesus on 01/07/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{
private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context=context;
        //obtenerMascotasBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas=new ConstructorMascotas(context);
       mascotas= constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void obtenerMediosRecientes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent= restApiAdapter.construyeGsonDeserializadorDeMediaRecent();
        EndpointsApi endpointsApi=restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);


        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse=response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Conexion fallida, ntenta de nuevo!!", Toast.LENGTH_LONG).show();
                Log.e("Falló la conexion", t.toString());
            }
        });


    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
