package com.example.noticiasapp;

import com.example.noticiasapp.Models.TitulosNoticias;

import java.util.List;
/* creo la clase Busqueda datos para poder manejar la respuesta del main activity */
public interface BusquedaDato<NoticiasApiRespuesta>{
    /* metodo obtener datos como una lista de los titulos de las noticias y tambien para recibir un mensaje  */
    void BusquedaDatoNews(List<TitulosNoticias> list, String mensaje);
    /* metodo para manejar el error */
    void amdinError(String mensaje);

}
