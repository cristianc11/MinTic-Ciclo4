package com.example.tienda_chaquetas.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tienda_chaquetas.R;


public class Fragment_sucursales extends Fragment {

    View vista;
    Drawable drawable1,drawable2;
    ImageView imagen1,imagen2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_sucursales, container, false);
        //------------------------------------------------------------------------------
        Resources res = getResources();
        drawable1 = res.getDrawable(R.drawable.sucursal1, vista.getContext().getTheme());
        imagen1 = (ImageView) vista.findViewById(R.id.imagen1);
        imagen1.setImageDrawable(drawable1);

        drawable2 = res.getDrawable(R.drawable.sucursal2, vista.getContext().getTheme());
        imagen2 = (ImageView) vista.findViewById(R.id.imagen2);
        imagen2.setImageDrawable(drawable2);


        //---------------------------------------------------------------------------------
        return vista;
    }
}