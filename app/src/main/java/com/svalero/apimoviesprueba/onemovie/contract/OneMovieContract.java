package com.svalero.apimoviesprueba.onemovie.contract;

import com.svalero.apimoviesprueba.beans.Movie;

import java.util.ArrayList;

public interface OneMovieContract {

    interface View {
        void showMovie(Movie movie);
    }

    interface Presenter {
        void deliverMovie(Movie movie);
        void getOneMovie(Movie movie);
    }

    interface Model {
        void getOneMovieFromList(Movie movie);
    }
}
