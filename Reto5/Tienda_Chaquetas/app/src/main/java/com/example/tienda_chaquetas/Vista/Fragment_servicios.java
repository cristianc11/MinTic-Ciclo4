package com.example.tienda_chaquetas.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tienda_chaquetas.Modelo.Adaptador;
import com.example.tienda_chaquetas.Modelo.BD.BaseDatosSQLite;
import com.example.tienda_chaquetas.Modelo.Entidad;
import com.example.tienda_chaquetas.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fragment_servicios extends Fragment {

    View vista;
    ListView listaServicios;
    Adaptador adaptador;
    int [] imagen = {R.drawable.servicio2,R.drawable.servicio3,R.drawable.servicio4};
    TextView mostrarDatos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_servicios, container, false);
        //------------------------------------------------------------------------------
        listaServicios = (ListView) vista.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(getTablaServicios(), getContext());

        listaServicios.setAdapter(adaptador);
        mostrarDatos = (TextView) vista.findViewById(R.id.prueba2);


        //---------------------------------------------------------------------------------
        return vista;
    }

    private ArrayList<Entidad> getTablaServicios() {
        ArrayList<Entidad> listaServicios = new ArrayList<>();
        String url = "https://gf6429688a181f3-proyectociclo4.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/servicios/servicios";
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String titulo = jsonObject.getString("titulo");

                        String descripcion = jsonObject.getString("descripcion");
                        listaServicios.add(new Entidad(imagen[i], titulo,descripcion));
                        mostrarDatos.setText(jsonObject.toString());

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        return listaServicios;
    }

}