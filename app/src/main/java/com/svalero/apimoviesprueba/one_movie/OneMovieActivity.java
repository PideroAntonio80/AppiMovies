package com.svalero.apimoviesprueba.one_movie;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;

public class OneMovieActivity extends AppCompatActivity {

    private ImageView image;
    private TextView tvTitulo;
    private TextView tvLengua;
    private TextView tvFecha;
    private TextView tvPuntos;
    private TextView tvVotos;
    private TextView tvSinopsis;
    private FloatingActionButton fabLike;

    boolean click = false;

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

        fabLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                click = !click;
                Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(), android.R.interpolator.fast_out_slow_in);
                v.animate()
                        .rotation(click ? 90f : 0)
                        .setInterpolator(interpolador)
                        .start();

                int colour = (click) ? Color.parseColor("#B2A42C") : Color.WHITE;
                fabLike.setColorFilter(colour);

                String message = (click) ? "Guardada en favoritos" : "Eliminada de favoritos";
                showToast(message);
            }
        });
    }

    public void initComponets() {
        image = (ImageView) findViewById(R.id.ivCaratula);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvLengua = (TextView) findViewById(R.id.tvLengua);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvPuntos = (TextView) findViewById(R.id.tvPuntos);
        tvVotos = (TextView) findViewById(R.id.tvVotos);
        tvSinopsis = (TextView) findViewById(R.id.tvSinopsis);
        tvSinopsis.setMovementMethod(new ScrollingMovementMethod());
        fabLike = (FloatingActionButton) findViewById(R.id.fab_like);
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

    public void showToast (String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}