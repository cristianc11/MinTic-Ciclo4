package com.example.tienda_chaquetas.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

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


public class Fragment_productos extends Fragment {


    int [] imagen = {R.drawable.chaqueta2, R.drawable.buzo1, R.drawable.chaqueta1 };

    String TAG = "Fragment_productos";

    View v;

    ListView listaProductos;
    Adaptador adaptador;
    TextView mostrarJSON;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_productos, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(getTablaProductos(), getContext());

        listaProductos.setAdapter(adaptador);
        mostrarJSON = (TextView) v.findViewById(R.id.prueba);


        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        String url="https://gf6429688a181f3-proyectociclo4.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/productos/productos";
        //String url="https://ge66797f0b4653f-modulo4reto4.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/productos/productos";
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i =0;i< jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");
                        listaProductos.add(new Entidad(imagen[i],titulo,descripcion));

                        mostrarJSON.setText(jsonObject.toString());
                    }
                }catch (JSONException e){
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
        //estado.setText(requestQueue.toString());


        return listaProductos;
    }


}