package com.example.dm2.ex20181109_1eval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button botSalir, botEntrar;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        botSalir = (Button) findViewById( R.id.salir );
        botEntrar = (Button) findViewById( R.id.entra );
    }


    public void salir( View view ) {
        finish();
    }


    public void entrar( View view ) {
        Intent intento = new Intent( this , Comprobacion.class  );
        startActivity( intento );
    }
}
