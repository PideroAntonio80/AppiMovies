package com.svalero.apimoviesprueba.retrofit;

import com.svalero.apimoviesprueba.beans.MoviesAPIResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    /*HashMap<String, String> datos = new HashMap();
             //CLAVE-VALOR      api_key = d9c4177bb1cc819d43088d25fbe2474c
            datos.put("api_key", "7e20756ea67b5217bad3146ba5b0c0e2");
            datos.put("language", "en-US");
            datos.put("page", "1");*/

    @GET("movie/popular?api_key=7e20756ea67b5217bad3146ba5b0c0e2&language=es-ES&page=1")
    Call<MoviesAPIResult> getMovies();
}
