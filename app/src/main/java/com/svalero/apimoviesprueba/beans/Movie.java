package com.svalero.apimoviesprueba.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {

    private int id;
    @SerializedName("title")
    private String titulo;
    @SerializedName("overview")
    private String sinopsis;
    @SerializedName("poster_path")
    private String image;
    @SerializedName("release_date")
    private String fecha;
    @SerializedName("vote_average")
    private String puntos;
    @SerializedName("vote_count")
    private int votos;
    @SerializedName("original_language")
    private String lengua;

    public static ArrayList<Movie> getListaFilterPuntos(ArrayList<Movie> lista) {
        Collections.sort(lista, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Integer.parseInt(new String(String.valueOf(o2.getPuntos().compareTo(new String(o1.getPuntos())))));
            }
        });
        return lista;
    }

    public static ArrayList<Movie> getListaFilterVotos(ArrayList<Movie> lista) {
        Collections.sort(lista, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return new Integer(o2.getVotos()).compareTo(new Integer(o1.getVotos()));
            }
        });
        return lista;
    }
}
