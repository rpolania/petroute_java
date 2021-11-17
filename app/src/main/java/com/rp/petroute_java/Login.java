package com.rp.petroute_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText nameUserInput, passUserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameUserInput = findViewById(R.id.nameUserInput);
        passUserInput = findViewById(R.id.passUserInput);

    }

    public void Ingresar (View view){
        String userId = nameUserInput.getText().toString();
        String userPass = passUserInput.getText().toString();

        if (userId.equals("admin") && userPass.equals("12345")){
            Intent i = new Intent(this, Forms.class);
            i.putExtra("Nombre", userId);
            startActivity(i);
        }else{
            Toast message = Toast.makeText(this, "Por favor verifica tu usuario y contraseña", Toast.LENGTH_LONG);
        }
    }
}