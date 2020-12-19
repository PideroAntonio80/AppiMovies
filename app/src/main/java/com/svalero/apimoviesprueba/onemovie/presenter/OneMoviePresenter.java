package com.svalero.apimoviesprueba.onemovie.presenter;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.onemovie.contract.OneMovieContract;
import com.svalero.apimoviesprueba.onemovie.model.OneMovieModel;
import com.svalero.apimoviesprueba.onemovie.view.OneMovieActivity;

public class OneMoviePresenter implements OneMovieContract.Presenter {

    private OneMovieModel oneMovieModel;
    private OneMovieActivity vista;

    public OneMoviePresenter(OneMovieActivity vista) {
        this.vista = vista;
        this.oneMovieModel = new OneMovieModel(this);
    }

    @Override
    public void deliverMovie(Movie movie) {
        if(vista != null) {
            vista.showMovie(movie);
        }
    }

    @Override
    public void getOneMovie(Movie movie) {
        if(oneMovieModel != null) {
            oneMovieModel.getOneMovieFromList(movie);
        }
    }
}
