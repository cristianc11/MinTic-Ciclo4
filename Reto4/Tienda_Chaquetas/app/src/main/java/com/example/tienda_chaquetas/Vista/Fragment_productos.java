package com.example.tienda_chaquetas.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import com.example.tienda_chaquetas.Modelo.Adaptador;
import com.example.tienda_chaquetas.Modelo.BD.BaseDatosSQLite;
import com.example.tienda_chaquetas.Modelo.Entidad;
import com.example.tienda_chaquetas.R;


public class Fragment_productos extends Fragment {


    int [] imagen = {R.drawable.buzo1, R.drawable.chaqueta1, R.drawable.chaqueta2 };

    String TAG = "Fragment_productos";

    View v;

    ListView listaProductos;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    BaseDatosSQLite conectar;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_productos, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(getTablaProductos(), getContext());

        listaProductos.setAdapter(adaptador);


        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        conectar = new BaseDatosSQLite(getContext(),"TiendaChaquetas", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM productos", null);
        Log.v(TAG, "leyendo bas de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro de while");
            listaProductos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(1), cursor.getString(2)));
            Log.v(TAG, "despues del while");
        }


        return listaProductos;
    }


    private ArrayList<Entidad> GetListItems(){
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.buzo1, "Buzo Rojo", "Buzo blanco con rojo especial para todos los momentos de frio"));
        listaItems.add(new Entidad(R.drawable.chaqueta1, "Chaqueta Pinguino", "Hermosa chaqueta con dibujo de pinguino para los amantes de estos animales"));
        listaItems.add(new Entidad(R.drawable.chaqueta2, "Beisbolera", "Chaqueta ocacional color blanco con negro, combina con cualquier prenda"));
        return listaItems;
    }


}