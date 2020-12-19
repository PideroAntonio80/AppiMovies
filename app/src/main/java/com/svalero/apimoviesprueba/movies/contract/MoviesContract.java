package com.svalero.apimoviesprueba.movies.contract;

import com.svalero.apimoviesprueba.beans.Movie;

import java.util.ArrayList;

public interface MoviesContract {

    interface View{
        void success(ArrayList<Movie> movies);
        void error(String message);
    }

    interface Presenter{
        void getMovies();
    }

    interface Model{
        /*Me tienes que mandar el Callback,
            camino de retorno*/
        void getMoviesWS(OnLstMoviesListener onLstMoviesListener);
        /*Programación Reactiva (Callback)*/
        interface OnLstMoviesListener{
            void resolve(ArrayList<Movie> movies);
            void reject(String error);
        }
    }
}
