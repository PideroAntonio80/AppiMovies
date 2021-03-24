package com.svalero.apimoviesprueba.movies.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.movies.contract.MoviesContract;
import com.svalero.apimoviesprueba.movies.presenter.MoviesPresenter;
import com.svalero.apimoviesprueba.trailer.TrailerActivity;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.View {

    private MoviesPresenter moviesPresenter;
    private FrameLayout fragmentContainer;
    private LinearLayout layoutError;
    private ProgressBar loading;
    private Button retry;
    private BottomNavigationView bottomNavigation;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        initComponents();
        initBottomNavigation();

        moviesPresenter = new MoviesPresenter(this);
        moviesPresenter.getMovies(this);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                bottomNavigation.setVisibility(View.GONE);
                fragmentContainer.setVisibility(View.GONE);
                layoutError.setVisibility(View.GONE);
                moviesPresenter.getMovies(getBaseContext());
            }
        });
    }

    public void initComponents() {
        fragmentContainer = findViewById(R.id.fragmentContainer);
        layoutError = (LinearLayout) findViewById(R.id.llLayoutError);
        loading = (ProgressBar) findViewById(R.id.pbLoading);
        retry = (Button) findViewById(R.id.bRetry);
        bottomNavigation = findViewById(R.id.bottom_navigation);
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        showFragment(ListMoviesFragment.newInstance(movies));
    }

    @Override
    public void success(ArrayList<Movie> movies) {
        bottomNavigation.setVisibility(View.VISIBLE);
        fragmentContainer.setVisibility(View.VISIBLE);
        layoutError.setVisibility(View.GONE);
        loading.setVisibility(View.GONE);

        this.movies = movies;

        showFragment(ListMoviesFragment.newInstance(movies));
    }

    @Override
    public void error(String message) {
        layoutError.setVisibility(View.VISIBLE);
        bottomNavigation.setVisibility(View.GONE);
        fragmentContainer.setVisibility(View.GONE);
        loading.setVisibility(View.GONE);
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public void initBottomNavigation(){
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.iBottom_bar_menu_movie:
                        showFragment(ListMoviesFragment.newInstance(new ArrayList<Movie>(movies)));
                        break;
                    case R.id.iBottom_bar_menu_rate:
                        showFragment(ListRateFragment.newInstance(new ArrayList<Movie>(movies)));
                        break;
                    case R.id.iBottom_bar_menu_favorite:
                        showFragment(ListVotesFragment.newInstance(new ArrayList<Movie>(movies)));
                        break;
                    case R.id.iBottom_bar_menu_music:
                        Intent intent = new Intent(getBaseContext(), TrailerActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });
    }
}
