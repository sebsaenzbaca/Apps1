package com.example.eva_4_interrupt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
int i = 10;
while (true) {
                try{
                    Thread.sleep(1000);
                    Log.wtf("Runnable 1", i + "");
                    i++;
                } catch (InterruptedException e){
                    e.printStackTrace();
                    //poner codigo para detener el Hilo
                    break;
                }
            }
        }
    };
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread (runnable);
        thread.start();
    }
    @Override
    protected void onStop(){
        super.onStop();
        thread.interrupt();
    }
}