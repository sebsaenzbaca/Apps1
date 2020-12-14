package com.example.eva2_3_intentos_explicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondaryActivity extends AppCompatActivity {
    //Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
       // intent = new Intent(this, MainActivity.class);

    }
    public void onClick(View v){
    //startActivity(intent);
    finish();
    }
}