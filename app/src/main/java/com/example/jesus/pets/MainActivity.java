package com.example.jesus.pets;
import com.example.jesus.pets.RestApi2.Endpoints;
import com.example.jesus.pets.RestApi2.adapter.RestApiAdapter;
import com.example.jesus.pets.RestApi2.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.*;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jesus.pets.adaptader.MascotaAdaptador;
import com.example.jesus.pets.adaptader.PageAdapter;
import com.example.jesus.pets.fragment.PerfilFragment;
import com.example.jesus.pets.fragment.RecyclerViewFragment;
import com.example.jesus.pets.pojo.Mascota;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            toolbar=(Toolbar) findViewById(R.id.miActionBar);
            tabLayout=(TabLayout) findViewById(R.id.tabLayout);
            viewPager=(ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();


        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }

        /*
        ListView lstMascotas = (ListView) findViewById(R.id.lstMascotas);
        lstMascotas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresMascota));
        lstMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
                intent.putExtra(getResources().getString(R.string.pnombre),mascotas.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptipo),mascotas.get(position).getTipo());
                intent.putExtra(getResources().getString(R.string.plikes),mascotas.get(position).getLikes());
                startActivity(intent);


            }
        });
        */
    }
    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, About.class );
                startActivity(intent);
                break;
            case R.id.mFavorito:
Intent intent1 =new Intent(this, Fav.class);
                startActivity(intent1);
                break;
            case R.id.mVerificarCuenta:
                Intent intent2 =new Intent(this, verificarCuenta.class);
                startActivity(intent2);
                break;
            case R.id.mtoken:
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d("TOKEN",token);
                RestApiAdapter restApiAdapter= new RestApiAdapter();
                Endpoints endpoints = restApiAdapter.establecerConexionRestApi();
                Call<UsuarioResponse> usuarioResponseCall = endpoints.registrarTokenID(token);
                usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
                    @Override
                    public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                        UsuarioResponse usuarioResponse = response.body();
                        Log.d("ID_FIREBASE", usuarioResponse.getId());
                        Log.d("TOKEN_FIREBASE", usuarioResponse.getToken());
                    }

                    @Override
                    public void onFailure(Call<UsuarioResponse> call, Throwable t) {

                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}
