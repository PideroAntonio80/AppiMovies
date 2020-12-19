package com.svalero.apimoviesprueba.filtromovies.presenter;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.filtromovies.contract.FilterMoviesContract;
import com.svalero.apimoviesprueba.filtromovies.model.FilterMoviesModel;
import com.svalero.apimoviesprueba.filtromovies.view.FilterMoviesActivity;

import java.util.ArrayList;

public class FilterMoviesPresenter implements FilterMoviesContract.Presenter {

    private FilterMoviesModel filterMoviesModel;
    private FilterMoviesActivity filterMoviesActivity;

    public FilterMoviesPresenter(FilterMoviesActivity filterMoviesActivity) {
        this.filterMoviesActivity = filterMoviesActivity;
        this.filterMoviesModel = new FilterMoviesModel(this);
    }

    @Override
    public void getMoviesFilterPuntos() {
        filterMoviesModel.getFilterPuntosFromList();
    }

    @Override
    public void getBackMoviesFilterPuntos(ArrayList<Movie> lista) {
        filterMoviesActivity.successPuntos(lista);
    }

    @Override
    public void getMoviesFilterVotos() {
        filterMoviesModel.getFilterVotosFromList();
    }

    @Override
    public void getBackMoviesFilterVotos(ArrayList<Movie> lista) {
        filterMoviesActivity.successVotos(lista);
    }
}
