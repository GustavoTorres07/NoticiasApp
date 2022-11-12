package com.example.noticiasapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VistaPersonalizada extends RecyclerView.ViewHolder {
    /* creo los objetos para los elementos de la vista del recyclerview */
    TextView texto_titulo,texto_fuente;
    ImageView imagen_titulo;
    /* creo un objeto para el cardview para poder crear el oyente para el recyclerview */
    CardView cardView;
    /* inicializo dentro del constructor */
    public VistaPersonalizada(@NonNull View itemView) {
        super(itemView);

        texto_titulo = itemView.findViewById(R.id.texto_titulo);
        texto_fuente = itemView.findViewById(R.id.texto_fuente);
        imagen_titulo = itemView.findViewById(R.id.imagen_titulo);
        /* inicializo el cardview para que el cardview llame a la vista de los elementos*/
        cardView = itemView.findViewById(R.id.contenedor_principal);

    }
}
