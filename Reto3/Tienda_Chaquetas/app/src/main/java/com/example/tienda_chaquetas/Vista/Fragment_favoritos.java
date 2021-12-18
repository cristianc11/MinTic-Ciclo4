package com.example.tienda_chaquetas.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tienda_chaquetas.Modelo.Adaptador;
import com.example.tienda_chaquetas.Modelo.BD.BaseDatosSQLite;
import com.example.tienda_chaquetas.Modelo.Entidad;
import com.example.tienda_chaquetas.R;

import java.util.ArrayList;

public class Fragment_favoritos extends Fragment {

    View vista;
    ListView listaFavoritos;
    Adaptador adaptador;
    int [] imagen = {R.drawable.buzo1,R.drawable.chaqueta1,R.drawable.chaqueta2};
    BaseDatosSQLite conector;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_favoritos, container, false);
        //------------------------------------------------------------------------------
        listaFavoritos = (ListView) vista.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(getTablaFavoritos(), getContext());

        listaFavoritos.setAdapter(adaptador);


        //---------------------------------------------------------------------------------
        return vista;
    }

    private ArrayList<Entidad> getTablaFavoritos(){
        ArrayList<Entidad> listaFavoritos = new ArrayList<>();
        conector = new BaseDatosSQLite(getContext(),"TiendaChaquetas", null, 1);
        SQLiteDatabase db_leer = conector.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM favoritos",null);

        while(cursor.moveToNext()){
            listaFavoritos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));
        }

        return listaFavoritos;
    }
}