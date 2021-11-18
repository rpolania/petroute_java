package com.rp.petroute_java;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    // implements View.OnClickListener
    // ViewHolder = Describe una vista de un elemento(CARD)y matadatos sobre su lugar dentro de RecyclerView
    // Para generar ese evento manual
    // private View.OnClickListener Listener;
    private List<ElementList> mData;
    private LayoutInflater mInflater; // Inflater = Describe de que archivo proviene o que tipo de dato es
    private Context context; // Context Nos indica de que clase estamos llamando al Adapter = ListAdapter

    // Contructor
    public ListAdapter(List<ElementList> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        // LayoutInflater = Se usa para crear instancias del contenido de los archivos XML
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){

        return mData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.element_list, parent, false);
        return new ListAdapter.ViewHolder(view);

        //view.setOnClickListener(this);

    }

    @Override
    // final = Tiene varios contextos:
    // 1. Modificador de no acceso aplicable a una variable, a un método o una clase
    // EX. No se pueden reasignar y debemos inicializarla
    // 2. Es una referencia de un objeto
    // Según la documentación es una buena práctica representar las variables finales en mayúsculas.
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int POSITION){
        holder.bindData(mData.get(POSITION));
    }

    public void setItems(List<ElementList> items){

        mData = items;
    }

    //public void setOnClickListener(View.OnClickListener listener){
    //this.listener=listener;
    //}

//    @Override
//    public void onClick(View view) {
//
//    }

    // ViewHolder = Describe una vista de un elemento(CARD)y matadatos sobre su lugar dentro de RecyclerView
    // Sub Clase
    public class ViewHolder extends RecyclerView.ViewHolder{ //Subclase
        ImageView iconImage;
        TextView name, country, status;

        // Metodo
        ViewHolder(View itemView){
            super(itemView); // Super = Se refiere a una variable local en un método.
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            country = itemView.findViewById(R.id.countryView);
            status = itemView.findViewById(R.id.statusTextView);
        }
        // GET = Obtener
        // SET = Modificar
        void bindData(final ElementList item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            // PorterDuff =  Describe la forma de combinar imagenes.
            // Crearon un articulo seminal sobre "Composición imágenes"
            name.setText(item.getName());// Cambiamos el nombre
            country.setText(item.getCountry());
            status.setText(item.getStatus());
        }
    }
}
