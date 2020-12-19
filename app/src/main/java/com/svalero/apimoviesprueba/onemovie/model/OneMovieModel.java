package com.svalero.apimoviesprueba.onemovie.model;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.onemovie.contract.OneMovieContract;
import com.svalero.apimoviesprueba.onemovie.presenter.OneMoviePresenter;

import java.util.ArrayList;

public class OneMovieModel implements OneMovieContract.Model {
    private OneMoviePresenter oneMoviePresenter;
    private ArrayList<Movie> lista;
    private Movie peli;

    public OneMovieModel(OneMoviePresenter oneMoviePresenter) {
        this.oneMoviePresenter = oneMoviePresenter;
    }


    @Override
    public void getOneMovieFromList(Movie movie) {
        lista = Movie.getLista();
        peli = new Movie();

        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getTitulo().equals(movie.getTitulo())) {
                peli = lista.get(i);
                if(peli != null) {
                    oneMoviePresenter.deliverMovie(peli);
                }
            }
        }

    }
}
