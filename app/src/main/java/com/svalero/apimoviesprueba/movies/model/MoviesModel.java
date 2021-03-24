package com.svalero.apimoviesprueba.movies.model;

import android.content.Context;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.beans.MoviesAPIResult;
import com.svalero.apimoviesprueba.movies.contract.MoviesContract;
import com.svalero.apimoviesprueba.retrofit.MovieNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesModel implements MoviesContract.Model {

    @Override
    public void getMoviesWS(Context context, final OnLstMoviesListener onLstMoviesListener) {

        MovieNetwork movieNetwork = new MovieNetwork(context);
        final Call<MoviesAPIResult> request = movieNetwork.getMovies();

        request.enqueue(new Callback<MoviesAPIResult>() {
            @Override
            public void onResponse(Call<MoviesAPIResult> call, Response<MoviesAPIResult> response) {
                if (response != null && response.body() != null) {
                    onLstMoviesListener.resolve(new ArrayList<Movie>(response.body().getResults()));
                }
            }

            @Override
            public void onFailure(Call<MoviesAPIResult> call, Throwable t) {
                    t.printStackTrace();
                    onLstMoviesListener.reject(t.getLocalizedMessage());
            }
        });
    }
}
