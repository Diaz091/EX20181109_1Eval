package com.example.dm2.ex20181109_1eval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class VerDatos extends AppCompatActivity {

    private TextView nombre ,   apellido    ,   sexo    ,   museos;



    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ver_datos );
        setTitle( "NUEVO USUARIO" );
        nombre      = (TextView) findViewById( R.id.nombreUsus );
        apellido    = (TextView) findViewById( R.id.apelUsu );
        sexo        = (TextView) findViewById( R.id.sexoUsu );
        museos      = (TextView) findViewById( R.id.museoUsu );

        Intent recibirDatos = getIntent();
        ArrayList<String> str = recibirDatos.getExtras().getStringArrayList("museos");

        String museo ="";
        for (String muse : str ) {
            museo += muse+" ";
        }

        nombre.setText("Nombre: " + recibirDatos.getExtras().getString("nombre"));
        apellido.setText("Apellidos: " + recibirDatos.getExtras().getString("apellido"));
        sexo.setText("Sexo: " +recibirDatos.getExtras().getString("sexo"));
        museos.setText("Tipo de Muesos Seleccionados: "+ museo);


    }

    public void aceptta( View view ) {
        finish();


    }

    public void rechazar( View view ) {
        finish();
    }
}
