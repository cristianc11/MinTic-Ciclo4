package com.example.tienda_chaquetas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    Drawable drawable1,drawable2;
    ImageView imagen1,imagen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Resources res = getResources();
        drawable1 = res.getDrawable(R.drawable.sucursal1, getTheme());
        imagen1 = (ImageView) findViewById(R.id.imagen1);
        imagen1.setImageDrawable(drawable1);

        drawable2 = res.getDrawable(R.drawable.sucursal2, getTheme());
        imagen2 = (ImageView) findViewById(R.id.imagen2);
        imagen2.setImageDrawable(drawable2);


    }
}