package com.example.tienda_chaquetas.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.tienda_chaquetas.Controlador.MainActivity;
import com.example.tienda_chaquetas.R;

public class SplashScreen extends AppCompatActivity implements Runnable{

    Thread h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logo = (ImageView)findViewById(R.id.logo1);
        logo.setBackgroundResource(R.drawable.load1);

        h1= new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class );
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   // @Override
    //protected void onRestart() {
     //   super.onRestart();
     //   try {
     //       Thread.sleep(1000);
      //      Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class );
       //     startActivity(pasarPantalla);
       // } catch (InterruptedException e) {
       //     e.printStackTrace();
       // }
    //}
}