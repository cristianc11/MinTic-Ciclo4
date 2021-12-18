package com.example.tienda_chaquetas.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.tienda_chaquetas.R;
import com.example.tienda_chaquetas.Vista.Fragment_favoritos;
import com.example.tienda_chaquetas.Vista.Fragment_inicio;
import com.example.tienda_chaquetas.Vista.Fragment_productos;
import com.example.tienda_chaquetas.Vista.Fragment_servicios;
import com.example.tienda_chaquetas.Vista.Fragment_sucursales;

/*
*
*@author Cristian
 */
public class MainActivity extends AppCompatActivity{

    Fragment_inicio subPantalla1;
    Fragment_productos subPantalla2;
    Fragment_servicios subPantalla3;
    Fragment_sucursales subPantalla4;
    Fragment_favoritos subPantalla5;
    FragmentTransaction intercambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantalla1 = new Fragment_inicio();
        subPantalla2 = new Fragment_productos();
        subPantalla3 = new Fragment_servicios();
        subPantalla4 = new Fragment_sucursales();
        subPantalla5 = new Fragment_favoritos();

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
        if (id == R.id.opcion1){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla5).commit();
        }
        if (id == R.id.opcion2){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
        }
        if (id == R.id.opcion3){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
        }
        if (id == R.id.opcion4){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla3).commit();
        }
        if (id == R.id.opcion5){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla4).commit();
        }
        return super.onOptionsItemSelected(item);
    }


}