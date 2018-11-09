package com.example.dm2.ex20181109_1eval;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Museos extends AppCompatActivity {
        private ListView listaMuseos;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_museos );
        setTitle( "LISTADO MUSEOS" );


        final Museo[] museos = {
                new Museo(getDrawable( R.mipmap.ic_guggenheim), "Museo Guggenheim de Bilbao"   , "Bilbo (Bizkaia)" ,"https://www.guggenheim-bilbao.eus/"),
                new Museo(getDrawable( R.mipmap.ic_bellas_artes), "Museo de Bellas Artes de Bilbao"   , "Bilbo (Bizkaia)", "http://www.museobilbao.com/"),
                new Museo(getDrawable( R.mipmap.ic_telmo1), "Museo San Telmo"   , "Donostia (Gipuzkoa)" ,"https://www.santelmomuseoa.eus"),
                new Museo(getDrawable( R.mipmap.ic_azkuna), "Azkuna Zentroa" , "Bilbo (Bizkaia)", "https://www.santelmomuseoa.eus"),
                new Museo(getDrawable( R.mipmap.ic_bellasartesv1 ), "Museo de Bellas Artes"  , "Gasteiz (Araba)" ,"https://www.azkunazentroa.eus"),
                new Museo(getDrawable( R.mipmap.ic_tabakalera), "Tabakalera"  , "Donostia (Gipuzkoa)" , "https://www.tabakalera.eu/eu"),
                new Museo(getDrawable( R.mipmap.ic_diocesanas), "Museo Diocesano de Arte Sacro"  , "Gasteiz (Araba)" ,"http://www.eleizmuseoa.com/")
        };

        AdaptadorMuseo adpM = new AdaptadorMuseo( this , museos );
        listaMuseos = findViewById( R.id.museos );
        listaMuseos.setAdapter( adpM );

        View header=getLayoutInflater().inflate(R.layout.lista_header,null);
        listaMuseos.addHeaderView(header);

        listaMuseos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Museo m= (Museo)parent.getItemAtPosition(position);
                Uri uri= Uri.parse( museos[position-1].getUrl() );

                if( uri!=null){
                    Intent inten = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity( inten );

                }else{
                    Toast.makeText(getApplicationContext(),"No hay URL DISPONIBLE",Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
