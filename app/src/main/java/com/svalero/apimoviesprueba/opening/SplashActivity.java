package com.svalero.apimoviesprueba.opening;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.MediaController;
import android.widget.VideoView;

import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.movies.view.MoviesActivity;

public class SplashActivity extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initComponents();

        String path = "android.resource://" + getPackageName() + "/" + R.raw.mgm;
        Uri uri = Uri.parse(path);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);

        video.requestFocus();
        video.start();

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
                }, 6000);
    }

    public void initComponents() {
        video = (VideoView) findViewById(R.id.vvLyon);
    }
}
