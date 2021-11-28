package com.example.tienda_chaquetas;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment_servicios extends Fragment {

    View vista;
    Drawable drawable1,drawable2,drawable3,drawable4;
    ImageView imagen1,imagen2,imagen3,imagen4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_servicios, container, false);
        //------------------------------------------------------------------------------
        Resources res = getResources();
        drawable1 = res.getDrawable(R.drawable.servicio1, vista.getContext().getTheme());
        imagen1 = (ImageView) vista.findViewById(R.id.imagen1);
        imagen1.setImageDrawable(drawable1);

        drawable2 = res.getDrawable(R.drawable.servicio2, vista.getContext().getTheme());
        imagen2 = (ImageView) vista.findViewById(R.id.imagen2);
        imagen2.setImageDrawable(drawable2);

        drawable3 = res.getDrawable(R.drawable.servicio3, vista.getContext().getTheme());
        imagen3 = (ImageView) vista.findViewById(R.id.imagen3);
        imagen3.setImageDrawable(drawable3);

        drawable4 = res.getDrawable(R.drawable.servicio4, vista.getContext().getTheme());
        imagen4 = (ImageView) vista.findViewById(R.id.imagen4);
        imagen4.setImageDrawable(drawable4);



        //---------------------------------------------------------------------------------
        return vista;
    }
}