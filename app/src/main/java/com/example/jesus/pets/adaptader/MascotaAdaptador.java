package com.example.jesus.pets.adaptader;
import com.google.gson.*;
import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.JsonElement;
import com.example.jesus.pets.DetalleMascota;
import com.example.jesus.pets.db.ConstructorMascotas;
import com.example.jesus.pets.pojo.Mascota;
import com.example.jesus.pets.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jesus on 28/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }
    //Inflar el layout y lo pasara al viewholder para el que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//Dar vida al cardview
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) { //asocia cada elemente de la lista con cada view

        final Mascota mascota=mascotas.get(position);
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.dog)
                .into(mascotaViewHolder.imgFoto);
       // mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
      //  mascotaViewHolder.tvNombre.setText(mascota.getNombre());
       // mascotaViewHolder.tvTipo.setText(mascota.getTipo());
        mascotaViewHolder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("url",mascota.getUrlFoto());
                 intent.putExtra("likes",mascota.getLikes());
                //intent.putExtra("foto",mascota.getLikes());

                activity.startActivity(intent);
            }
        });
        /*
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste like a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvLikes.setText(constructorMascotas.obtenerLikeMascota(mascota)+"likes");

            }
        });
        */
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene la batilista

        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
       // private TextView tvNombre;
        //private TextView tvTipo;
        //private ImageButton btnLike;
        private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto =(ImageView) itemView.findViewById(R.id.imgvFoto);
            //tvNombre=(TextView) itemView.findViewById(R.id.tvNombre);
            //tvTipo=(TextView) itemView.findViewById(R.id.tvTipo);
            //btnLike=(ImageButton) itemView.findViewById(R.id.btnLike) ;
            tvLikes=(TextView) itemView.findViewById(R.id.tvLikes);
        }
    }


}
