package com.example.noticiasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noticiasapp.Models.TitulosNoticias;
import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {
    TitulosNoticias titulos;
    TextView txt_titulo, txt_author, txt_hora, txt_detalle, txt_contenido;
    ImageView img_notcias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txt_titulo = findViewById(R.id.texto_detalle_titulo);
        txt_author = findViewById(R.id.texto_detalle_author);
        txt_hora = findViewById(R.id.texto_detalle_hora);
        txt_detalle = findViewById(R.id.texto_detalle_detalle);
        txt_contenido = findViewById(R.id.texto_detalle_contenido);
        img_notcias = findViewById(R.id.img_detalle_noticias);

        titulos = (TitulosNoticias) getIntent().getSerializableExtra("dato");


        txt_titulo.setText(titulos.getTitle());
        txt_author.setText(titulos.getAuthor());
        txt_hora.setText(titulos.getPublishedAt());
        txt_detalle.setText(titulos.getDescription());
        txt_contenido.setText(titulos.getContent());
        Picasso.get().load(titulos.getUrlToImage()).into(img_notcias);

    }
}