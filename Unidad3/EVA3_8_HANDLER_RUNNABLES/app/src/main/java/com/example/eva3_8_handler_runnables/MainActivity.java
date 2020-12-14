package com.example.eva3_8_handler_runnables;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtVwMensa;
    int i ;
    Handler miHandler = new Handler();
    Runnable backGroundRun = new Runnable() {
        @Override
        public void run() {
             i = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                miHandler.post(foreGroundRun);
                Log.wtf("tHilo", i + "");
                i++;
            }
        }
    };
    Runnable foreGroundRun = new Runnable() {
        @Override
        public void run() {
            txtVwMensa.append("valor i = " + i + "\n");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.txtVwMensa);

        Thread tHilo = new Thread(backGroundRun);
        tHilo.start();
    }
}