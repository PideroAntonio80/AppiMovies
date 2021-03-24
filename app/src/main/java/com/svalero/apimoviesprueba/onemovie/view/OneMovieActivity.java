package com.svalero.apimoviesprueba.onemovie.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;

public class OneMovieActivity extends AppCompatActivity /*implements OneMovieContract.View*/ {

    private ImageView image;
    private TextView tvTitulo;
    private TextView tvLengua;
    private TextView tvFecha;
    private TextView tvPuntos;
    private TextView tvVotos;
    private TextView tvSinopsis;

//    private OneMoviePresenter oneMoviePresenter;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_movie);

        initComponets();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            movie = (Movie) bundle.getSerializable("my_movie");
        }

        showMovie();
    }

    public void initComponets() {
        image = (ImageView) findViewById(R.id.ivCaratula);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvLengua = (TextView) findViewById(R.id.tvLengua);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvPuntos = (TextView) findViewById(R.id.tvPuntos);
        tvVotos = (TextView) findViewById(R.id.tvVotos);
        tvSinopsis = (TextView) findViewById(R.id.tvSinopsis);
    }

    public void showMovie() {
        String urlBase = "https://image.tmdb.org/t/p/original";

        Picasso.get().load(urlBase + movie.getImage()).into(image);
        tvTitulo.setText(movie.getTitulo());
        tvLengua.setText(movie.getLengua());
        tvFecha.setText(movie.getFecha());
        tvPuntos.setText(movie.getPuntos());
        tvVotos.setText(String.valueOf(movie.getVotos()));
        tvSinopsis.setText(movie.getSinopsis());
    }
}