package com.example.jesus.pets.db;
import com.google.gson.JsonElement;
import android.content.ContentValues;
import android.content.Context;
import com.google.gson.*;
import com.example.jesus.pets.R;
import com.example.jesus.pets.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by jesus on 01/07/2016.
 */
public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }
    public ArrayList<Mascota> obtenerDatos(){
       /* ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.dog,"Juancho","Perro",10));
        mascotas.add(new Mascota(R.drawable.firulais,"Firulais","Perro",4));
        mascotas.add(new Mascota(R.drawable.cat,"Bobo","Gato",3));
        mascotas.add(new Mascota(R.drawable.turtle,"Tortuguin","Tortuga",2));
return mascotas;
*/
        BaseDatos db= new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodasLasMascotas();

    }
    public void insertarTresMascotas(BaseDatos db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Juancho");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TIPO,"PERRO");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.dog);

        db.instertarMascota(contentValues);
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Firulais");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TIPO,"PERRO");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.firulais);

        db.instertarMascota(contentValues);
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Bobo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TIPO,"GATO");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.cat);

        db.instertarMascota(contentValues);
        contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"LALOCA");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TIPO,"TORTUGA");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.turtle);

        db.instertarMascota(contentValues);
    }
    public void darLikeMascota (Mascota mascota){
        BaseDatos db= new BaseDatos(context);
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);


    }
    public int obtenerLikeMascota (Mascota mascota){

        BaseDatos db= new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }
}
