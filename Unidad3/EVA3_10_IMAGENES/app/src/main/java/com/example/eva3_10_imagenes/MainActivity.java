package com.example.eva3_10_imagenes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
ImageView imgVmImagen;
Bitmap imagen;

Handler handler = new Handler(){
    @Override
    public void handleMessage (@NonNull Message msg){
        super.handleMessage(msg);
        imgVmImagen.setImageBitmap(imagen);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVmImagen = findViewById(R.id.imgVwImagen);
        Thread tHilo = new Thread(){
            @Override
            public void run(){
                super.run();
                imagen = cargarImagen("https://i.pinimg.com/originals/03/3d/a1/033da1ee73dee68196ec2a5494d457ef.jpg");
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            }
        };

    }

    public Bitmap cargarImagen (String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}