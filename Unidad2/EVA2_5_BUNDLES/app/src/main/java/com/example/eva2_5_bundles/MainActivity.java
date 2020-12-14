package com.example.eva2_5_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] datos ={
            "Chihuahua",
            "Parral",
            "Delicias",
            "Juarez",
            "Camargo",
            "Jimenez",
            "Casas Grandes",
            "Durango",
            "Hermosillo",
            "Obregon",
            "Mexicali",
            "Nogales",
            "Saltillo",
            "Torreon",
            "Piedras negras",
            "Monterrey",
            "Acuña",
            "Tampico",
            "Ciudad Victoria",



    };
    Intent intent;
    ListView lstVWDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVWDatos = findViewById(R.id.lstVWDatos);
        intent = new Intent(this, DetailActivity.class);
        lstVWDatos.setAdapter(new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1,datos));

        lstVWDatos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Bundle bundle = new Bundle();
                bundle.putString("CIUDAD",datos[i]);
                bundle.putInt("pocision",i);
                intent.putExtras(bundle);
startActivity (intent);
            }

        });
    }
}