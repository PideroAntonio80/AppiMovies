package com.svalero.apimoviesprueba.movies.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.movies.contract.MoviesContract;
import com.svalero.apimoviesprueba.movies.presenter.MoviesPresenter;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.View {

    private MoviesPresenter moviesPresenter;
    private Spinner spinner;
    private LinearLayout layoutError;
    private ProgressBar loading;
    private Button retry;
    private ArrayList<Movie> originalMovies;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        initComponents();

        loading.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.GONE);
        layoutError.setVisibility(View.GONE);

        moviesPresenter = new MoviesPresenter(this);
        moviesPresenter.getMovies();

        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this,
                R.array.listaOpciones, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getSelectedItem().toString().equals("--Por Puntuacion--")){
                    showFragment(ListRateFragment.newInstance(new ArrayList<Movie>(movies)));
                }
                else if (parent.getSelectedItem().toString().equals("--Por Votos--")){
                    showFragment(ListVotesFragment.newInstance(new ArrayList<Movie>(movies)));
                }
                else if (parent.getSelectedItem().toString().equals("Principal")){
                    showFragment(ListMoviesFragment.newInstance(new ArrayList<Movie>(movies)));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.GONE);
                layoutError.setVisibility(View.GONE);
            }
        });

    }

    public void initComponents() {
        spinner = findViewById(R.id.sSpinner);
        layoutError = (LinearLayout) findViewById(R.id.llLayoutError);
        loading = (ProgressBar) findViewById(R.id.pbLoading);
        retry = (Button) findViewById(R.id.bRetry);
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
        spinner.setVisibility(View.VISIBLE);
        layoutError.setVisibility(View.GONE);
        loading.setVisibility(View.GONE);

        this.movies = movies;

        showFragment(ListMoviesFragment.newInstance(movies));
    }

    @Override
    public void error(String message) {
        layoutError.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.GONE);
        loading.setVisibility(View.GONE);
    }
}
