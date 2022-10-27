package com.example.noticiasapp;

import com.example.noticiasapp.Models.TitulosNoticias;

import java.util.List;

public interface BusquedaDato<NoticiasApiRespuesta>{

    void BusquedaDatoNews(List<TitulosNoticias> list, String mensaje);
    void amdinError(String mensaje);

}
