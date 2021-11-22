package com.example.examenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cambiaractivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.editText), editText2 = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero1String = editText.getText().toString(), numero2String = editText2.getText().toString();
                if (numero1String.equals("") || numero2String.equals("")) {
                    return;
                }
                Toast toast1 =Toast.makeText(getApplicationContext(),"Toast por defecto", Toast.LENGTH_SHORT);
                toast1.show();
                int numero1 = Integer.parseInt(numero1String), numero2 = Integer.parseInt(numero2String);
                int suma = numero1 + numero2;
                Intent intent = new Intent(cambiaractivity.this, activity2.class);
                intent.putExtra("suma", suma);
                startActivity(intent);
            }
        });
    }
}
