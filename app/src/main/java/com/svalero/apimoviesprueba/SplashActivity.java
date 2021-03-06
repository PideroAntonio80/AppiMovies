package com.svalero.apimoviesprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.svalero.apimoviesprueba.movies.view.MoviesActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() { // Interface
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        Intent navegar = new Intent(
                                getBaseContext(), MoviesActivity.class);
                        startActivity(navegar);
                    }
                }, 4000);
    }
}