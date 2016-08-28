package com.example.jesus.pets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.jesus.pets.restApi.jsonKeys;

public class verificarCuenta extends AppCompatActivity {
public static EditText usuario2;
    public static String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_cuenta);
        usuario="tortuguin33";
    }

    public void extraerUser () {

        usuario2= (EditText) findViewById(R.id.edVerificarCuenta);
usuario=usuario2.getText().toString();
    }
    public void enviarId(){
        extraerUser();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }
}
