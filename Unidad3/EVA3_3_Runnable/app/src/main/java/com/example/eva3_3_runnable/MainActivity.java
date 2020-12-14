package com.example.eva3_3_runnable;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    Log.wtf("Runnable", i + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(runnable);
        thread.start();
        MiRunnable miRunnable = new MiRunnable();
        Thread thread1 = new Thread(miRunnable);
        thread1.start();
    }
}

class MiRunnable implements Runnable{
    @Override
    public void run(){

    }
}