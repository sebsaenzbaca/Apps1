package com.example.eva_3_9_banner;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewBanner;
    int[] imagenes = {R.drawable.pepe, R.drawable.pepe2, R.drawable.pepe3};
    int indice = 0;
    Handler handler = new Handler();
    Runnable forG = new Runnable() {
        @Override
        public void run() {
            imageViewBanner.setImageResource(imagenes[indice]);
            if (indice == 2) {
                indice = 0;
            } else {
                indice++;
            }
        }
    };
    Runnable backG = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(forG);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewBanner = findViewById(R.id.imageViewBanner);

        Thread hilo = new Thread(backG);
        hilo.start();
    }
}