package com.svalero.apimoviesprueba.retrofit;

import android.content.Context;

import com.svalero.apimoviesprueba.BuildConfig;
import com.svalero.apimoviesprueba.beans.MoviesAPIResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieNetwork {

    private Retrofit retrofit;
    private Context context;

    public MovieNetwork(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Call<MoviesAPIResult> getMovies() {
        MovieApi api = retrofit.create(MovieApi.class);
        return api.getMovies();
    }
}
