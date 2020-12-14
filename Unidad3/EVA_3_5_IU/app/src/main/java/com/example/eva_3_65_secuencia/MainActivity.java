package com.example.eva_3_65_secuencia;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView TxtVwDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtVwDatos = findViewById(R.id.TxtVwDatos);

        Thread tHilo = new Thread() {
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.wtf("MiRunnable", i + "");
                    TxtVwDatos.append(i + "\n");
                    i++;
                }
            }
        };
        tHilo.start();
    }
}