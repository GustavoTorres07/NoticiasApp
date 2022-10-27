package com.example.noticiasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noticiasapp.Models.TitulosNoticias;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPersonalizado extends RecyclerView.Adapter<VistaPersonalizada> {
    private Context contexto;
    private List<TitulosNoticias> titulos;
    private SeleccionarOyente oyente;
    @NonNull
    @Override
    public VistaPersonalizada onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VistaPersonalizada(LayoutInflater.from(contexto).inflate(R.layout.lista_items, parent, false));
    }

    public AdapterPersonalizado(Context contexto, List<TitulosNoticias> titulos, SeleccionarOyente oyente ) {
        this.contexto = contexto;
        this.titulos = titulos;
        this.oyente = oyente;
    }

    @Override
    public void onBindViewHolder(@NonNull VistaPersonalizada holder, int position) {

        holder.texto_titulo.setText(titulos.get(position).getTitle());
        holder.texto_fuente.setText(titulos.get(position).getSource().getName());

        if(titulos.get(position).getUrlToImage()!=null){
            Picasso.get().load(titulos.get(position).getUrlToImage()).into(holder.imagen_titulo);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyente.NoticiasClick(titulos.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return titulos.size();
    }
}
