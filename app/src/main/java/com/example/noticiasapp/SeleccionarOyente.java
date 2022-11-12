package com.example.noticiasapp;

import com.example.noticiasapp.Models.TitulosNoticias;

// oyente para que al hacer click en un elemento de vista del recylerview lo muestre dentro de una nueva activity
public interface SeleccionarOyente {
    // creo un metodo llamado noticiasclick y le paso como parametro el objeto de titulosnoticias
    void NoticiasClick(TitulosNoticias titulares);
}
