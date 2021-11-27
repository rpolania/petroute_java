package com.rp.petroute_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Mascotas extends AppCompatActivity {
    List<ElementList> elements; // Metodo global
    Dialogo d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        init(); // NEW

    }
    public void init(){
        elements = new ArrayList<>(); // Instancia del objeto elements
        elements.add(new ElementList("#775347", "Mascota 1", "Hacienda", "Activo")); // Tarjeta 0
        elements.add(new ElementList("#775447", "Mascota 2", "Mazuren", "Activo")); // Tarjeta 1
        elements.add(new ElementList("#607d8b", "Mascota 3", "Colina", "Activo")); // Tarjeta 2
        elements.add(new ElementList("#03a9f4", "Mascota 4", "Balcones", "Activo")); // Tarjeta 3
        elements.add(new ElementList("#009688", "Mascota 5", "Cedritos", "Activo")); // Tarjeta 4


        // Declaramos el ListAdapter y recibe una lista y el context = de donde viene
        ListAdapter listAdapter = new ListAdapter(elements, this);
        // Declaramos el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        // Movemos unos parametros en verdadero
        recyclerView.setHasFixedSize(true);
        // Listado lineal setLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        recyclerView.setAdapter(listAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int nro = item.getItemId();
        float valor;

        //SET = Modificar
        //GET = Obtener

        switch (nro){
            case R.id.route:
                Toast.makeText(Mascotas.this,"Has seleccionado proceder a ruta",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.deleteDog:
                Toast.makeText(Mascotas.this,"Has seleccionado eliminar perro de la ruta",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.salir:
                finish();
                //Llamar dialogo acá para confirmar logout
                //d = new Dialogo(Mascotas.this,"Titulo","Texto");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}