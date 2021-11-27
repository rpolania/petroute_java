package com.rp.petroute_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.rp.petroute_java.persistencia.DbUsers;

public class Login extends AppCompatActivity {

    EditText username, password;
    DbUsers DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        TextView name = findViewById(R.id.nameUserInput);
        TextView passwd = findViewById(R.id.passUserInput);

//        username = findViewById(R.id.btnlogin);
//        password = findViewById(R.id.btnregister);

// Seguro que estos botones son del login??? o son del Register???
        MaterialButton loginBut = findViewById(R.id.btnlogin);
        MaterialButton registerBut = findViewById(R.id.btnregister);
        DB = new DbUsers(this);

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String pass = passwd.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(Login.this, "Todos los espacios son requeridos", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkPassword(user, pass);
                    if (checkuserpass == true) {
                        Intent intent = new Intent(getApplicationContext(), Mascotas.class);
                        startActivity(intent);
                        Toast.makeText(Login.this, "Login correcto", Toast.LENGTH_SHORT).show();
//                        Dialog d = new Dialog(Login.this,"Aqui va el titulo","Hola gente", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
////                                Intent intent = new Intent(getApplicationContext(), CardsItems.class);
////                                startActivity(intent);
//                            }
//                        });
                    } else {
                        Toast.makeText(Login.this, "Login incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });


        registerBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiamos de layout/Vista
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}
