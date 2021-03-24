package com.svalero.apimoviesprueba.trailer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.svalero.apimoviesprueba.R;

public class TrailerActivity extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        initComponents();

        //String path = "https://youtu.be/E4WOafOX300";
        //String path = "http://techslides.com/demos/sample-videos/small.mp4";
        //String path = "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";

        String path = "android.resource://" + getPackageName() + "/" + R.raw.mrdos;
        Uri uri = Uri.parse(path);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);

        mediaController.setAnchorView(video);

        //video.requestFocus();
        //video.start();
    }

    public void initComponents() {
        video = (VideoView) findViewById(R.id.vvTrailer);
    }
}