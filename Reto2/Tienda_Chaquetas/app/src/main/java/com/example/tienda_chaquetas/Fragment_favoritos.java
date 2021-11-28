package com.example.tienda_chaquetas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_favoritos extends Fragment {

    View vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_favoritos, container, false);
        //------------------------------------------------------------------------------



        //---------------------------------------------------------------------------------
        return vista;
    }
}