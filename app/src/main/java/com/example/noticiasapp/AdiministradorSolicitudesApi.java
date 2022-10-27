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

public class AdiministradorSolicitudesApi {

    Context contexto;


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public void getTitulosNoticias(BusquedaDato oyente, String category, String query){


        LlamadaApiNoticias llamadaApiNoticias = retrofit.create(LlamadaApiNoticias.class);
        Call<NoticiasApiRespuesta> call = llamadaApiNoticias.llamarTitulos("ar", category, query, contexto.getString(R.string.api_key));
        try{

            call.enqueue(new Callback<NoticiasApiRespuesta>() {
                @Override
                public void onResponse(Call<NoticiasApiRespuesta> call, Response<NoticiasApiRespuesta> response) {
                    if (!response.isSuccessful()){

                        Toast.makeText(contexto, "Error!", Toast.LENGTH_SHORT).show();
                        
                    }

                    oyente.BusquedaDatoNews(response.body().getArticles(), response.message());

                }

                @Override
                public void onFailure(Call<NoticiasApiRespuesta> call, Throwable t) {

                    oyente.amdinError("Solicitud Fallida!");

                }
            });

        }
        catch (Exception e){

            e.printStackTrace();

        }

    }


    public AdiministradorSolicitudesApi(Context contexto) {
        this.contexto = contexto;
    }

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
