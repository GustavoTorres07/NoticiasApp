package com.example.noticiasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.noticiasapp.Models.NoticiasApiRespuesta;
import com.example.noticiasapp.Models.TitulosNoticias;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SeleccionarOyente, View.OnClickListener {
    RecyclerView recyclerView;
    AdapterPersonalizado adaptador;
    ProgressDialog dialogo;
    Button b1,b2,b3,b4,b5,b6,b7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogo = new ProgressDialog(this);
        dialogo.setTitle("Buscando Noticias");
        dialogo.show();

        b1 = findViewById(R.id.btn_1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.btn_2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.btn_3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.btn_4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.btn_5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.btn_6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.btn_7);
        b7.setOnClickListener(this);

        AdiministradorSolicitudesApi administrador = new AdiministradorSolicitudesApi(this);
        administrador.getTitulosNoticias(oyente, "general", null);

    }

    private final BusquedaDato<NoticiasApiRespuesta> oyente = new BusquedaDato<NoticiasApiRespuesta>() {
        @Override
        public void BusquedaDatoNews(List<TitulosNoticias> list, String mensaje) {
            showNews(list);
            dialogo.dismiss();

        }

        @Override
        public void amdinError(String mensaje) {

        }
    };

    private void showNews(List<TitulosNoticias> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adaptador = new AdapterPersonalizado(this, list, this);
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void NoticiasClick(TitulosNoticias titulares) {

        startActivity(new Intent(MainActivity.this, DetalleActivity.class)
                .putExtra("dato", titulares));

    }

    @Override
    public void onClick(View v) {
        Button boton = (Button) v;
        String categoria = boton.getText().toString();
        dialogo.setTitle("Buscando articulos de " + categoria );
        dialogo.show();
        AdiministradorSolicitudesApi administrador = new AdiministradorSolicitudesApi(this);
        administrador.getTitulosNoticias(oyente, categoria, null);
    }
}