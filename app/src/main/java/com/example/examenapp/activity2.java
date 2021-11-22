package com.example.examenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /* Obtenemos los datos que nos pasaron. El 0 es por si no se nos pasara
        nada, ya que se necesita un valor por defecto (defaultValue)*/
        Intent intent = getIntent();
        int sumaQueNosPasaron = intent.getIntExtra("suma", 0);
        // Obtenemos el textView
        TextView textView = findViewById(R.id.textView);
        // Montamos el mensaje de salida
        String mensaje = "La suma es: " + sumaQueNosPasaron;
        // Y mostramos la suma
        textView.setText(mensaje);
    }
}