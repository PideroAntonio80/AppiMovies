package com.svalero.apimoviesprueba.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Movie implements Serializable {
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String OVERVIEW = "overview";
    private static final String POSTER_PATH = "poster_path";
    private static final String FECHA = "release_date";
    private static final String PUNTOS = "vote_average";
    private static final String VOTOS = "vote_count";
    private static final String LENGUA = "original_language";
    private static final String GENERO = "genre_ids";

    private static ArrayList<Movie> listaFilterVotos;
    private static ArrayList<Movie> lista;
    private int id;
    private String titulo;
    private String sinopsis;

    private String image;
    private String fecha;
    private String puntos;
    private int votos;
    private String lengua;
    private String genero;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getPuntos() {
        return puntos;
    }
    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
    public int getVotos() {
        return votos;
    }
    public void setVotos(int votos) {
        this.votos = votos;
    }
    public String getLengua() {
        return lengua;
    }
    public void setLengua(String lengua) {
        this.lengua = lengua;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public static ArrayList<Movie> getArrayListFromJSON(JSONArray lstMovies){
        lista = null;
        try {
            if(lstMovies!=null && lstMovies.length() > 0 ){
                lista = new ArrayList<Movie>();
            }
            for (int i = 0; i < lstMovies.length(); i++) {
                JSONObject json_data = lstMovies.getJSONObject(i);
                Movie movie = new Movie();

                movie.setId(json_data.getInt(ID));
                movie.setTitulo(json_data.getString(TITLE));
                movie.setSinopsis(json_data.getString(OVERVIEW));
                movie.setImage("https://image.tmdb.org/t/p/original" + json_data.getString(POSTER_PATH));
                movie.setFecha(json_data.getString(FECHA));
                movie.setPuntos(json_data.getString(PUNTOS));
                movie.setVotos(json_data.getInt(VOTOS));
                movie.setLengua(json_data.getString(LENGUA));
                movie.setGenero(json_data.getString(GENERO));

                lista.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static ArrayList<Movie> getLista() {
        return lista;
    }

    public static ArrayList<Movie> getListaFilterPuntos() {
        Collections.sort(lista, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Integer.parseInt(new String(String.valueOf(o2.getPuntos().compareTo(new String(o1.getPuntos())))));
            }
        });
        return lista;
    }

    public static ArrayList<Movie> getListaFilterVotos() {
        Collections.sort(lista, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return new Integer(o2.getVotos()).compareTo(new Integer(o1.getVotos()));
            }
        });
        return lista;
    }

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
