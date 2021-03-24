package com.svalero.apimoviesprueba.onemovie.model;

import android.content.Context;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.beans.MoviesAPIResult;
import com.svalero.apimoviesprueba.onemovie.contract.OneMovieContract;
import com.svalero.apimoviesprueba.onemovie.presenter.OneMoviePresenter;
import com.svalero.apimoviesprueba.retrofit.MovieNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneMovieModel /*implements OneMovieContract.Model*/ {
    /*private OneMoviePresenter oneMoviePresenter;
    private ArrayList<Movie> lista;
    private Movie peli;
    private Movie myMovie;

    public OneMovieModel(OneMoviePresenter oneMoviePresenter) {
        this.oneMoviePresenter = oneMoviePresenter;
    }

    @Override
    public void getOneMovieFromList(Context context, Movie movie) {
        this.myMovie = movie;

        MovieNetwork movieNetwork = new MovieNetwork(context);
        final Call<MoviesAPIResult> request = movieNetwork.getMovies();

        request.enqueue(new Callback<MoviesAPIResult>() {
            @Override
            public void onResponse(Call<MoviesAPIResult> call, Response<MoviesAPIResult> response) {
                if (response != null && response.body() != null) {
                    lista = new ArrayList<Movie>(response.body().getResults());

                    peli = new Movie();

                    for(int i = 0; i < lista.size(); i++) {
                        if(lista.get(i).getTitulo().equals(myMovie.getTitulo())) {
                            peli = lista.get(i);
                            if(peli != null) {
                                oneMoviePresenter.deliverMovie(peli);
                            }
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<MoviesAPIResult> call, Throwable t) {
                t.printStackTrace();
//                onLstMoviesListener.reject(t.getLocalizedMessage());
            }
        });
        *//*lista = Movie.getLista();
        System.out.println(lista.get(0).getTitulo());
        peli = new Movie();

        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getTitulo().equals(movie.getTitulo())) {
                peli = lista.get(i);
                if(peli != null) {
                    oneMoviePresenter.deliverMovie(peli);
                }
            }
        }*//*
    }*/
}
