package com.rp.petroute_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Mascotas extends AppCompatActivity {
    List<ElementList> elements; // Metodo global

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas);

        init(); // NEW

    }
    public void init(){
        elements = new ArrayList<ElementList>(); // Instancia del objeto elements
        elements.add(new ElementList("#775447", "Producto 2", "Colombia", "Activo")); // Tarjeta 1
        elements.add(new ElementList("#607d8b", "Producto 3", "Colombia", "Activo")); // Tarjeta 2
        elements.add(new ElementList("#03a9f4", "Producto 4", "Colombia", "Activo")); // Tarjeta 3
        elements.add(new ElementList("#009688", "Producto 5", "Colombia", "Activo")); // Tarjeta 4


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
}