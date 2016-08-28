package com.example.jesus.pets;
import com.google.gson.*;
import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleMascota extends AppCompatActivity {
    private static final String KEY_EXTRA_URL="url";
    private static final String KEY_EXTRA_LIKES="likes";
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);
        Toolbar miActionBar =(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        Bundle parametros= getIntent().getExtras();

            String url  =    parametros.getString(KEY_EXTRA_URL);

           int likes    =    parametros.getInt(KEY_EXTRA_LIKES);

        TextView tvLikesDetalle   =    (TextView)findViewById(R.id.tvLikesDetalle);
       // TextView tvTipo     =    (TextView)findViewById(R.id.tvTipo);
       // TextView tvLikes    =    (TextView)findViewById(R.id.tvLikes);
imgFotoDetalle = (ImageView) findViewById(R.id.imgvFoto) ;

        tvLikesDetalle.setText(String.valueOf(likes));
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.dog)
                .into(imgFotoDetalle);

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
        }
        return super.onOptionsItemSelected(item);
    }
}
