package com.example.dm2.ex20181109_1eval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Comprobacion extends AppCompatActivity {

    private TextView num1 , num2 ,texto1 , texto2, textDesp;
    private EditText resultado;
    private Spinner  opciones;
    private String   opcion;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_comprobacion );

    num1 = (TextView) findViewById( R.id.num1 );
    num2 = (TextView) findViewById( R.id.num2 );

    resultado = ( EditText ) findViewById( R.id.result );


    texto1 = (TextView ) findViewById( R.id.salida );
    texto2 = (TextView ) findViewById( R.id.salida2 );


    textDesp = (TextView) findViewById( R.id.menuDespl );

    opciones = (Spinner) findViewById( R.id.opciones );


    }

    public void compro( View view ) {
        int result =14;

        if( Integer.parseInt( resultado.getText().toString() ) == result ){
            texto1.setText( "¡ PERFECTO!" );
            texto2.setText( "No eres una maquina" );

           textDesp.setText("Elige una de las opciones en el desplegable");

            final String[] options = {"Elija Opcion:","Darse de Alta" , "Ver Lista Museos"};

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, options);
            adaptador.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item);

            opciones.setAdapter( adaptador );

            opciones.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected( AdapterView< ? > parent, View view, int position, long id ) {
                    opcion = opciones.getSelectedItem().toString();
                    nuevActivity( opcion );
                }

                @Override
                public void onNothingSelected( AdapterView< ? > parent ) {

                }
            } );

        }else{
           finish();
        }

    }

    public void nuevActivity(String opc ){
        if( opcion.toString().equalsIgnoreCase( "Darse de Alta" )){
            Intent alta = new Intent( this, AltaUsu.class );
            startActivity( alta );
        }

        if( opcion.toString().equalsIgnoreCase( "Ver lista museos" )){
            Intent museos = new Intent( this, Museos.class );
            startActivity( museos );
        }
    }



}
