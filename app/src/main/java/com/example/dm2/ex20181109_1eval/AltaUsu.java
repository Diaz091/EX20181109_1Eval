package com.example.dm2.ex20181109_1eval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;

public class AltaUsu extends AppCompatActivity {
    private EditText    textoNombre ,   textoApellido;
    private RadioButton masculino   ,   femenino;
    private CheckBox    arte       ,   ciencia ,   otros;
    private String      sexo="algo";
    private ArrayList<String> museo = new ArrayList<String>();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_altausu );
        setTitle( "NUEVO USUARIO" );


        textoNombre     = (EditText)    findViewById ( R.id.nombre   );
        textoApellido   = (EditText)    findViewById ( R.id.apellido );

        masculino       = (RadioButton) findViewById ( R.id.masc );
        femenino        = (RadioButton) findViewById ( R.id.fem  );

        arte            = (CheckBox)    findViewById ( R.id.arte   );
        ciencia         = (CheckBox)    findViewById ( R.id.ciencia  );
        otros           = (CheckBox)    findViewById ( R.id.otros );

    }




    public void cancelar( View view ) {
        finish();
    }

    public void alta( View view ) {

        sexo = (masculino.isChecked() ) ?"Masculino":"Femenino";

        if( arte.isChecked() ){
            museo.add(arte.getText().toString() );
        }
        if( ciencia.isChecked() ){
            museo.add( ciencia.getText().toString());
        }
        if( otros.isChecked() ){
            museo.add( otros.getText().toString());
        }

        Intent  verDatos = new Intent( this, VerDatos.class );
                verDatos.putExtra("nombre"    , textoNombre.getText().toString()   );
                verDatos.putExtra("apellido"  , textoApellido.getText().toString() );
                verDatos.putExtra("sexo"      , sexo );
                verDatos.putExtra("museos" , museo);
        startActivity( verDatos );


    }


    public EditText getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre( EditText textoNombre ) {
        this.textoNombre = textoNombre;
    }

    public EditText getTextoApellido() {
        return textoApellido;
    }

    public void setTextoApellido( EditText textoApellido ) {
        this.textoApellido = textoApellido;
    }

    public RadioButton getMasculino() {
        return masculino;
    }

    public void setMasculino( RadioButton masculino ) {
        this.masculino = masculino;
    }

    public RadioButton getFemenino() {
        return femenino;
    }

    public void setFemenino( RadioButton femenino ) {
        this.femenino = femenino;
    }

    public CheckBox getArte() {
        return arte;
    }

    public void setArte( CheckBox arte ) {
        this.arte = arte;
    }

    public CheckBox getCiencia() {
        return ciencia;
    }

    public void setCiencia( CheckBox ciencia ) {
        this.ciencia = ciencia;
    }

    public CheckBox getOtros() {
        return otros;
    }

    public void setOtros( CheckBox otros ) {
        this.otros = otros;
    }
}
