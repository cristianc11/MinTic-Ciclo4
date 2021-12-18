package com.example.tienda_chaquetas.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tienda_chaquetas.Modelo.Adaptador;
import com.example.tienda_chaquetas.Modelo.BD.BaseDatosSQLite;
import com.example.tienda_chaquetas.Modelo.Entidad;
import com.example.tienda_chaquetas.R;

import java.util.ArrayList;

public class Fragment_servicios extends Fragment {

    View vista;
    ListView listaServicios;
    Adaptador adaptador;
    int [] imagen = {R.drawable.servicio2,R.drawable.servicio3,R.drawable.servicio4};
    BaseDatosSQLite conector;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_servicios, container, false);
        //------------------------------------------------------------------------------
        listaServicios = (ListView) vista.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(getTablaServicios(), getContext());

        listaServicios.setAdapter(adaptador);


        //---------------------------------------------------------------------------------
        return vista;
    }

    private ArrayList<Entidad> getTablaServicios(){
        ArrayList<Entidad> listaServicios = new ArrayList<>();
        conector = new BaseDatosSQLite(getContext(),"TiendaChaquetas", null, 1);
        SQLiteDatabase db_leer = conector.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM servicios", null);

        while(cursor.moveToNext()){
            listaServicios.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));
        }


        return listaServicios;
    }

    private ArrayList<Entidad> GetListItems(){
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.servicio2, "Domicilios", "Domicilios a cualquier parte del pais!."));
        listaItems.add(new Entidad(R.drawable.servicio3,"Presencial","Encontraras muchas promociones en nuetras tiendas!"));
        listaItems.add(new Entidad(R.drawable.servicio4,"Pagos","Recibimos varios metodos para tu mayor comodidad."));
        return listaItems;
    }
}