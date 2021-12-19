package com.example.tienda_chaquetas.Modelo.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatosSQLite extends SQLiteOpenHelper {

    public BaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* ====================================================================================================== */
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT,descripcion TEXT)");

        /* ====================================================================================================== */
        //TABLA PRODUCTOS
        db.execSQL("CREATE TABLE productos (imagen INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO productos VALUES ( 0, 'Buzo','Buzo blanco con rojo')");
        db.execSQL("INSERT INTO productos VALUES ( 1, 'Pinguino','Chaqueta negra con imagen de pinguino')");
        db.execSQL("INSERT INTO productos VALUES ( 2, 'Beisbolera','Chaqueta blanca con negro')");

        /* ====================================================================================================== */
        //TABLA SERVICIOS
        db.execSQL("CREATE TABLE servicios (imagen INT,titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO servicios VALUES (0,'Domicilios','Domicilios a cualquier parte del pais!.')");
        db.execSQL("INSERT INTO servicios VALUES (1,'Presencial','Ven y visitanos en nuestras tiendas, encontraras muchas promociones!')");
        db.execSQL("INSERT INTO servicios VALUES (2,'Pagos','Recibimos varios metodos para tu mayor comodidad.')");
        /* ====================================================================================================== */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);

    }
}