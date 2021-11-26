package com.rp.petroute_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {

    private EditText nameUserInput, passUserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView name = findViewById(R.id.nameUserInput);
        TextView pass = findViewById(R.id.passUserInput);

        MaterialButton loginBut = findViewById(R.id.btnlogin);
        MaterialButton registerBut = findViewById(R.id.btnregister);

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userId = name.getText().toString();
                String userPass = pass.getText().toString();

                if (userId.equals("admin") && userPass.equals("12345")){
                    Toast.makeText(Login.this, "Bienvenido a PetRoute", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login.this, Mascotas.class);
                    i.putExtra("Nombre", userId);
                    startActivity(i);
                }else{
                    Toast.makeText(Login.this, "Ops! no estas registrado. Ingresa en el botón Registrate o verifica tus credenciales", Toast.LENGTH_LONG).show();
                }

            }
        });

        registerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registro(v,name,pass);
            }
        });


    }

    public void Registro (View view, TextView name, TextView pass){
        String userId = name.getText().toString();
        String userPass = pass.getText().toString();

            Intent i = new Intent(Login.this, Register.class);
            i.putExtra("Nombre", userId);
            startActivity(i);
            Toast.makeText(Login.this, "Llena tus datos", Toast.LENGTH_SHORT).show();

    }
}