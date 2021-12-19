package com.example.tienda_chaquetas.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.tienda_chaquetas.Modelo.BD.BaseDatosSQLite;
import com.example.tienda_chaquetas.R;

import org.w3c.dom.Text;


public class Adaptador extends BaseAdapter {

    ArrayList<Entidad> lista_items;
    Context context;

    // CONEXION A LA BASE DE DATOS: SQLite
    BaseDatosSQLite conectar;



    public Adaptador(ArrayList<Entidad> lista_items, Context context) {
        this.lista_items = lista_items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista_items.size();
    }

    @Override
    public Object getItem(int posicion) {
        return lista_items.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return 0; }

    @Override
    public View getView(int posicion, View v, ViewGroup viewGroup) {

        Entidad datosItem = (Entidad) getItem(posicion);

        v = LayoutInflater.from(context).inflate(R.layout.item, null);
        //-------------------------------------------------------------------

        ImageView imagen = (ImageView) v.findViewById(R.id.imagen1_item);
        TextView titulo = (TextView)v.findViewById(R.id.titulo_item);
        TextView descripcion = (TextView)v.findViewById(R.id.descripcion_item);
        Button boton1 = (Button) v.findViewById(R.id.boton1_item);

        imagen.setImageResource(datosItem.getImagen());
        titulo.setText(datosItem.getTitulo());
        descripcion.setText(datosItem.getDescripcion());
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conectar = new BaseDatosSQLite(context,"TiendaChaquetas", null, 1);
                SQLiteDatabase db_escribir = conectar.getWritableDatabase();
                Toast.makeText(context, "Guardado en favoritos", Toast.LENGTH_LONG).show();
                db_escribir.execSQL("INSERT INTO favoritos VALUES ('"+datosItem.getImagen()+"', '"+datosItem.getTitulo()+"','"+datosItem.getDescripcion()+"')");
            }
        });

        /*
        Pongo los datos de cada item desde la clase Entidad dentro de cada elemento xml
         */


        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item:" + titulo.getText(), Toast.LENGTH_LONG ).show();
            }
        });

        //-------------------------------------------------------------------
        return v;
    }

}
