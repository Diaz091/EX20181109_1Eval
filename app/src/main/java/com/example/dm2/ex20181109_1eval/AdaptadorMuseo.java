package com.example.dm2.ex20181109_1eval;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorMuseo extends ArrayAdapter<Museo> {

    private Museo[] museos;

    AdaptadorMuseo( Context contexto , Museo[] museos ){

        super(contexto , R.layout.lista_items2, museos);
        this.museos = museos;
    }

    @NonNull
    @Override
    public View getView( int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from( getContext() );
        View vista = inflater.inflate( R.layout.lista_items2, null);

        ImageView img = vista.findViewById( R.id.imgMus );
        img.setImageDrawable( museos[ position ].getImg() );

        TextView nombre = vista.findViewById( R.id.nomMuseo );
        nombre.setText( museos[ position ].getNombre() );

        TextView sitio = vista.findViewById( R.id.sitio );
        sitio.setText( museos[ position ].getFrase());

        return vista;
    }
}
