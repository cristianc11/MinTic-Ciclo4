package com.example.tienda_chaquetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {

    Drawable drawable1,drawable2,drawable3,drawable4;
    ImageView imagen1,imagen2,imagen3,imagen4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Resources res = getResources();
        drawable1 = res.getDrawable(R.drawable.servicio1, getTheme());
        imagen1 = (ImageView) findViewById(R.id.imagen1);
        imagen1.setImageDrawable(drawable1);

        drawable2 = res.getDrawable(R.drawable.servicio2, getTheme());
        imagen2 = (ImageView) findViewById(R.id.imagen2);
        imagen2.setImageDrawable(drawable2);

        drawable3 = res.getDrawable(R.drawable.servicio3, getTheme());
        imagen3 = (ImageView) findViewById(R.id.imagen3);
        imagen3.setImageDrawable(drawable3);

        drawable4 = res.getDrawable(R.drawable.servicio4, getTheme());
        imagen4 = (ImageView) findViewById(R.id.imagen4);
        imagen4.setImageDrawable(drawable4);


    }
}