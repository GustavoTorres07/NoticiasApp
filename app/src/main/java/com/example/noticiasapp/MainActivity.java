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
/* implemento el seleccionaroyente */
public class MainActivity extends AppCompatActivity implements SeleccionarOyente, View.OnClickListener {
    /* creo un objeto para el recyclerview */
    RecyclerView recyclerView;
    /* creo un objeto para el adaptador personalizado */
    AdapterPersonalizado adaptador;
    /* defino un objeto global para mostrar un dialogo mientras carga */
    ProgressDialog dialogo;
    /* defino los botones */
    Button b1,b2,b3,b4,b5,b6,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* inicializo el dialogo para mostrar cada vez que se inicie la aplicacion */
        dialogo = new ProgressDialog(this);
        /* le paso un titulo */
        dialogo.setTitle("Buscando Noticias");
        /* asi muestro el dialogo */
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
        /* llamo al objeto administrador para obtener los titulares de las noticias
        * le paso la consulta y la categoria que quiero que busque y muestre primero */
        administrador.getTitulosNoticias(oyente, "general", null);

    }

    /* obtener datos de la respuesta de la api */
    private final BusquedaDato<NoticiasApiRespuesta> oyente = new BusquedaDato<NoticiasApiRespuesta>() {
        @Override
        public void BusquedaDatoNews(List<TitulosNoticias> list, String mensaje) {
            showNews(list);
            /* una vez que recibo las noticias osea que se muestran en el recyclerview oculto ese dialogo */
            dialogo.dismiss();

        }

        @Override
        public void amdinError(String mensaje) {

        }
    };

    /* metodo para mostrar noticias y el paramentro es la lista de titulos de noticias */
    private void showNews(List<TitulosNoticias> list) {
        /* dentro inicio el recylerview */
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        /* inicio el adaptador personalizado */
        adaptador = new AdapterPersonalizado(this, list, this);
        /* agrego el adaptador al recyclerview */
        recyclerView.setAdapter(adaptador);
    }

   public void NoticiasClick(TitulosNoticias titulares) {

        /* activity de inicio y detalle
        * paso el objeto de titulares a la nueva activity */
        startActivity(new Intent(MainActivity.this, DetalleActivity.class)
                .putExtra("dato", titulares));

    }

    /* metodo onclick para los botones*/
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