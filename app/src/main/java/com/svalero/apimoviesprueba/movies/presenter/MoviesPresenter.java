package com.svalero.apimoviesprueba.movies.presenter;

import android.content.Context;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.movies.contract.MoviesContract;
import com.svalero.apimoviesprueba.movies.model.MoviesModel;

import java.util.ArrayList;

public class MoviesPresenter implements MoviesContract.Presenter {

    private MoviesModel moviesModel;
    private MoviesContract.View vista;

    public MoviesPresenter(MoviesContract.View vista) {
        this.vista = vista;
        this.moviesModel = new MoviesModel();
    }
    @Override
    public void getMovies(Context context) {
        moviesModel.getMoviesWS(context, new MoviesContract.Model.OnLstMoviesListener() {
            @Override
            public void resolve(ArrayList<Movie> movies) {
                vista.success(movies);
            }
            @Override
            public void reject(String error) {
                vista.error(error);
            }
        });
    }
}
