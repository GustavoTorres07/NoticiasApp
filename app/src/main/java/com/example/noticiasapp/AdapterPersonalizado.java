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

import retrofit2.http.Url;

// le paso el soporte de vista
public class AdapterPersonalizado extends RecyclerView.Adapter<VistaPersonalizada> {
    // creo un objeto para el contexto
    private Context contexto;
    // creo un objeto para poder pasar la lista de los titulares de las noticias al recyclerview para poder mostrarlos */
    // lo llamo titulos
    private List<TitulosNoticias> titulos;
    // creo un objeto para el oyente y lo agrego al constructor del adapterpersonalizado*/
    private SeleccionarOyente oyente;
    @NonNull
    @Override
    public VistaPersonalizada onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // en vez de retornar un nulo, lo modifico para que devuelva una vista personalizada */
        return new VistaPersonalizada(LayoutInflater.from(contexto).inflate(R.layout.lista_items, parent, false));
    }

    public AdapterPersonalizado(Context contexto, List<TitulosNoticias> titulos, SeleccionarOyente oyente ) {
        this.contexto = contexto;
        this.titulos = titulos;
        this.oyente = oyente;
    }

    /* le agrego los objetos del titulo de la noticia, dentro llamo a las vistas de textos (titulo y fuente) y a la vista de la imagen
    * agrego los datos para esas vistas
    * para mostrar la imagen de ese articulo de noticia dentro de la vista de imagen uso picasso
    * int position para que segun la posicion pueda obtener el titulo  */
    @Override
    public void onBindViewHolder(@NonNull VistaPersonalizada holder, int position) {

        holder.texto_titulo.setText(titulos.get(position).getTitle());
        holder.texto_fuente.setText(titulos.get(position).getSource().getName());
    /* verifico si la url de la imagen esta vacio o no, en caso de estar vacio
    * no se muestra ninguna imagen, de forma predeteminada se mostrara la imagen que puse en la carpeta drawable llamada no_imagen.jpg */
        if(titulos.get(position).getUrlToImage()!=null){
            Picasso.get().load(titulos.get(position).getUrlToImage()).into(holder.imagen_titulo);

        }

        // vinculo el titulo de la vista y el oyente
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyente.NoticiasClick(titulos.get(position));
            }
        });


    }

    // modifico el returno 0 para que me devuelva el tamaño de los titulares
    @Override
    public int getItemCount() {
        return titulos.size();
    }
}
