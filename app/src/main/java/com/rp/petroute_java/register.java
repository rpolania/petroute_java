package com.rp.petroute_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MaterialButton registerButton = findViewById(R.id.loginBut);
        MaterialButton backButton = findViewById(R.id.backLogin);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroAction(v);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regreso(v);
            }
        });
    }

    public void registroAction(View v){
        Intent registrado = new Intent(register.this,Login.class);
        startActivity(registrado);
        Toast.makeText(register.this,"Te has registrado exitosamente!",Toast.LENGTH_LONG).show();

    }

    public void regreso(View v){
        Intent regresar = new Intent(register.this,Login.class);
        Toast.makeText(register.this,"Valida tu ingreso",Toast.LENGTH_LONG).show();
        startActivity(regresar);
    }
}