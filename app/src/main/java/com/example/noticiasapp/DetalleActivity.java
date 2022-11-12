package com.example.noticiasapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noticiasapp.Models.TitulosNoticias;
import com.squareup.picasso.Picasso;

import retrofit2.http.Url;

// activity detalle de las noticias */
public class DetalleActivity extends AppCompatActivity {
    // creo un objeto para los titulares de las noticias */
    TitulosNoticias titulos;
    TextView txt_titulo, txt_author, txt_hora, txt_detalle, txt_contenido;
    ImageView img_notcias;
    Button btn_url;

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

        // intent para ir a una noticia mediante la url
        btn_url = findViewById(R.id.btn_url);
        btn_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(titulos.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // creo la flecha para volver atras
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("News Noticias");
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // llamo al objeto de tituales de las noticias */
        titulos = (TitulosNoticias) getIntent().getSerializableExtra("dato");


        txt_titulo.setText(titulos.getTitle());
        txt_author.setText(titulos.getAuthor());
        txt_hora.setText(titulos.getPublishedAt());
        txt_detalle.setText(titulos.getDescription());
        txt_contenido.setText(titulos.getContent());
        Picasso.get().load(titulos.getUrlToImage()).into(img_notcias);

    }
}