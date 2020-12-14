package com.example.eva2_3_intentos_explicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Action : El objeto que lanza la nueva actividad
        //Data: La clase de la nueva actividad
        intent = new Intent(this, SecondaryActivity.class);

    }
    public void onClick(View v){
        StartActivity(intent);
    }
}