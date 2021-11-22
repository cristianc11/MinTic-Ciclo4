package com.example.tienda_chaquetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    Drawable drawable1,drawable2,drawable3;
    ImageView imagen2,imagen3,imagen4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Resources res = getResources();
        drawable1 = res.getDrawable(R.drawable.buzo1, getTheme());

        imagen2 = (ImageView) findViewById(R.id.imagen1);
        imagen2.setImageDrawable(drawable1);

        drawable2 = res.getDrawable(R.drawable.chaqueta1, getTheme());

        imagen3 = (ImageView) findViewById(R.id.imagen2);
        imagen3.setImageDrawable(drawable2);

        drawable3 = res.getDrawable(R.drawable.chaqueta2, getTheme());

        imagen4 = (ImageView) findViewById(R.id.imagen3);
        imagen4.setImageDrawable(drawable3);

    }
}