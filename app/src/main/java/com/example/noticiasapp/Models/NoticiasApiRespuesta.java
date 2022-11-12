package com.example.noticiasapp.Models;

import java.io.Serializable;
import java.util.List;

public class NoticiasApiRespuesta implements Serializable {

    String status = "";
    int totalResults;
    // creo una lista de articulos y el tipo de la lista es el objeto TitulosNoticias //
    // (lo llamo articles porque asi esta definido en la api) //
    List<TitulosNoticias> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }


    public List<TitulosNoticias> getArticles() {
        return articles;
    }

    public void setArticles(List<TitulosNoticias> articles) {
        this.articles = articles;
    }
}
