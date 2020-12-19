package com.svalero.apimoviesprueba.movies.model;

import android.os.AsyncTask;

import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.movies.contract.MoviesContract;
import com.svalero.apimoviesprueba.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MoviesModel implements MoviesContract.Model {
    private static final String URL ="https://api.themoviedb.org/3/movie/popular?api_key=7e20756ea67b5217bad3146ba5b0c0e2&language=en-US&page=1";
    private ArrayList<Movie> lstArrayMovies;
    OnLstMoviesListener onLstMoviesListener;

    @Override
    public void getMoviesWS(final OnLstMoviesListener onLstMoviesListener) {
        this.onLstMoviesListener = onLstMoviesListener;
        ApiCollector apiCollector = new ApiCollector();
        apiCollector.execute();
    }

    /*MONTO LA CÁPSULA QUE ME PERMITE VIAJAR AL API*/

    class ApiCollector extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            Post post = new Post();

            HashMap<String, String> datos = new HashMap();
             //CLAVE-VALOR      api_key = d9c4177bb1cc819d43088d25fbe2474c
            datos.put("api_key", "7e20756ea67b5217bad3146ba5b0c0e2");
            datos.put("language", "en-US");
            datos.put("page", "1");
            try {
                JSONObject objectMovies = post.getServerDataGetObject(URL);
                JSONArray lstMovies = objectMovies.getJSONArray("results");
                lstArrayMovies = Movie.getArrayListFromJSON(lstMovies);
                //System.out.println(lstArrayMovies.get(1).getTitulo());
            } catch (JSONException je) {
                je.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            if(resp){
                if(lstArrayMovies!=null && lstArrayMovies.size()>0){
                    onLstMoviesListener.resolve(lstArrayMovies);
                }
            }else{
                onLstMoviesListener.reject("Error al traer los datos del Servidor.");
            }
        }
    }
}
