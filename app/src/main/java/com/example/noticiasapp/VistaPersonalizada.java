package com.example.noticiasapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VistaPersonalizada extends RecyclerView.ViewHolder {
    TextView texto_titulo,texto_fuente;
    ImageView imagen_titulo;
    CardView cardView;
    public VistaPersonalizada(@NonNull View itemView) {
        super(itemView);

        texto_titulo = itemView.findViewById(R.id.texto_titulo);
        texto_fuente = itemView.findViewById(R.id.texto_fuente);
        imagen_titulo = itemView.findViewById(R.id.imagen_titulo);
        cardView = itemView.findViewById(R.id.contenedor_principal);

    }
}
