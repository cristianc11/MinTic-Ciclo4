package com.example.tienda_chaquetas.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tienda_chaquetas.R;

public class Fragment_inicio extends Fragment {


    View vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_inicio, container, false);
        //------------------------------------------------------------------------------



        //---------------------------------------------------------------------------------
        return vista;
    }
}