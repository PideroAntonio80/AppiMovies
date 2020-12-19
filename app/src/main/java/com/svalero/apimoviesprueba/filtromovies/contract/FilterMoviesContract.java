package com.svalero.apimoviesprueba.filtromovies.contract;

import com.svalero.apimoviesprueba.beans.Movie;

import java.util.ArrayList;

public interface FilterMoviesContract {

    interface View{
        void successPuntos(ArrayList<Movie> moviesPuntos);
        void successVotos(ArrayList<Movie> moviesVotos);
        void error(String message);
    }

    interface Presenter{
        void getMoviesFilterPuntos();
        void getBackMoviesFilterPuntos(ArrayList<Movie> listaVotos);

        void getMoviesFilterVotos();
        void getBackMoviesFilterVotos(ArrayList<Movie> listaLengua);
    }

    interface Model{
        void getFilterPuntosFromList();
        void getFilterVotosFromList();
    }
}
