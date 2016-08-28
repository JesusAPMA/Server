package com.example.jesus.pets.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.*;
import com.example.jesus.pets.R;
import com.example.jesus.pets.adaptader.MascotaAdaptador;
import com.example.jesus.pets.pojo.Mascota;
import com.example.jesus.pets.presentador.IRecyclerViewFragmentPresenter;
import com.example.jesus.pets.presentador.RecyclerViewFragmentPresenter;
import com.google.gson.JsonElement;
import java.util.ArrayList;

/**
 * Created by jesus on 01/07/2016.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);
presenter=new RecyclerViewFragmentPresenter(this, getContext());
        return v;

        // return super.onCreateView(inflater, container, savedInstanceState);
    }
/*
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.dog,"Juancho","Perro","10"));
        mascotas.add(new Mascota(R.drawable.firulais,"Firulais","Perro","4"));
        mascotas.add(new Mascota(R.drawable.cat,"Bobo","Gato","3"));
        mascotas.add(new Mascota(R.drawable.turtle,"Tortuguin","Tortuga","2"));

    }
*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(), 2);
        rvMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
