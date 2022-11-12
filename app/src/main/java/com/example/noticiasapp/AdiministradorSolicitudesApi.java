package com.example.noticiasapp;

import android.content.Context;
import android.widget.Toast;

import com.example.noticiasapp.Models.NoticiasApiRespuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Clase para administrar la llamadas a la api
public class AdiministradorSolicitudesApi {

    // creo un objeto para el contexto */
    Context contexto;

// creo un objeto para retrofit para poder hacer la llamada a la api
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // metodo para administrar la llamada a la api
    public void getTitulosNoticias(BusquedaDato oyente, String category, String query){

        // creo un objeto llamada a la api
        LlamadaApiNoticias llamadaApiNoticias = retrofit.create(LlamadaApiNoticias.class);
        // creo un objeto de llamada
        Call<NoticiasApiRespuesta> call = llamadaApiNoticias.llamarTitulos("ar", category, query, contexto.getString(R.string.api_key));
        // creo el try catch donde llamare a la api
        try{

            call.enqueue(new Callback<NoticiasApiRespuesta>() {
                @Override
                public void onResponse(Call<NoticiasApiRespuesta> call, Response<NoticiasApiRespuesta> response){
                    // si la respuesta no es exitosa
                    if (!response.isSuccessful()){

                        Toast.makeText(contexto, "Error!", Toast.LENGTH_SHORT).show();
                        
                    }
                    // con el primer paramentro obtengo los articulos de noticias, y luego en el segundo paramentro le paso el mensaje
                    oyente.BusquedaDatoNews(response.body().getArticles(), response.message());

                }

                @Override
                public void onFailure(Call<NoticiasApiRespuesta> call, Throwable t) {
                // en caso de no obtener los articulos muestra el siguiente mensaje
                    oyente.amdinError("Solicitud Fallida!");

                }
            });

        }
        catch (Exception e){

            e.printStackTrace();

        }

    }


    /* constructor */
    public AdiministradorSolicitudesApi(Context contexto) {

        this.contexto = contexto;
    }

    /* creo una interfaz para manejar la llamada a la api
    * creo las consultas con la anotacion @Query */
    public interface LlamadaApiNoticias {
        @GET("top-headlines")
        Call<NoticiasApiRespuesta> llamarTitulos(
                @Query("country") String country,
                @Query("category") String category,
                @Query("q") String query,
                @Query("apiKey") String api_key
        );

    }



}
