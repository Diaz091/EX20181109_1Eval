package com.example.dm2.ex20181109_1eval;

import android.graphics.drawable.Drawable;

public class Museo{
        private Drawable img;
        private String nombre,frase , url;

        Museo(Drawable i, String n, String f , String u){
            img=i;
            nombre=n;
            frase=f;
            url = u;
        }


        public Drawable getImg() {

            return img;
        }

        public String getNombre() {

            return nombre;
        }

        public String getFrase() {
            return frase;
        }

        public String getUrl() {
        return url;
    }
}