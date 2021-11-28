package com.example.tienda_chaquetas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/*
*
*@author Cristian
 */
public class MainActivity extends AppCompatActivity {

    Fragment_inicio subPantalla1;
    Fragment_productos subPantalla2;
    Fragment_servicios subPantalla3;
    Fragment_sucursales subPantalla4;
    Fragment subPantalla5;
    FragmentTransaction intercambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantalla1 = new Fragment_inicio();
        subPantalla2 = new Fragment_productos();
        subPantalla3 = new Fragment_servicios();
        subPantalla4 = new Fragment_sucursales();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mInicio){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
        }
        if (id == R.id.mProductos){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
        }
        if (id == R.id.mServicios){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla3).commit();
        }
        if (id == R.id.mSucursales){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla4).commit();
        }
        return super.onOptionsItemSelected(item);
    }

}