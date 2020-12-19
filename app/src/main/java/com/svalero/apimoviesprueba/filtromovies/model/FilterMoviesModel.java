package com.svalero.apimoviesprueba.filtromovies.model;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.filtromovies.contract.FilterMoviesContract;
import com.svalero.apimoviesprueba.filtromovies.presenter.FilterMoviesPresenter;

import java.util.ArrayList;

public class FilterMoviesModel implements FilterMoviesContract.Model {

    private FilterMoviesPresenter filterMoviesPresenter;
    private ArrayList<Movie> lstArrayMoviesFilterPuntos;
    private ArrayList<Movie> lstArrayMoviesFilterVotos;

    public FilterMoviesModel(FilterMoviesPresenter filterMoviesPresenter) {
        this.filterMoviesPresenter = filterMoviesPresenter;
    }

    @Override
    public void getFilterPuntosFromList() {
        lstArrayMoviesFilterPuntos = Movie.getListaFilterPuntos();
        if(lstArrayMoviesFilterPuntos != null) {
            filterMoviesPresenter.getBackMoviesFilterPuntos(lstArrayMoviesFilterPuntos);
        }

    }

    @Override
    public void getFilterVotosFromList() {
        lstArrayMoviesFilterVotos = Movie.getListaFilterVotos();
        if(lstArrayMoviesFilterVotos != null) {
            filterMoviesPresenter.getBackMoviesFilterVotos(lstArrayMoviesFilterVotos);
        }
    }
}
