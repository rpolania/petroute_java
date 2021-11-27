package com.rp.petroute_java;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rp.petroute_java.persistencia.DbUsers;

public class Register extends AppCompatActivity {
    EditText username1, password1, repassword, correo;
    Button btnRegistro, btnBack; // Variable Global
    DbUsers DB;

    // Ciclo de vida de android = se ejecuta al iniciar nuestra activity onCreate, onStart, onResume.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username1 = findViewById(R.id.nameUser);
        password1 = findViewById(R.id.passUser);
        repassword = findViewById(R.id.rePassUser);
        correo = findViewById(R.id.emailUser);
        btnRegistro = findViewById(R.id.registrBut);
        btnBack = findViewById(R.id.backLogin);
        DB = new DbUsers (Register.this);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username1.getText().toString(); //
                String pass = password1.getText().toString();
                String repass = repassword.getText().toString();
                String email = correo.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) || TextUtils.isEmpty(email))
                    Toast.makeText(Register.this, "Se requiere llenar los campos", Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkUserName(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertUser(user, pass, email);
                            Log.d("Estado de insert",insert.toString());
                            if (insert == true) {
                                Toast.makeText(Register.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Mascotas.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(Register.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Register.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new  Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });

    }
}
