package com.svalero.apimoviesprueba.movies.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.filtromovies.view.FilterMoviesActivity;
import com.svalero.apimoviesprueba.movies.adapter.ListAdapter;
import com.svalero.apimoviesprueba.movies.contract.MoviesContract;
import com.svalero.apimoviesprueba.movies.presenter.MoviesPresenter;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.View {

    private RecyclerView recycler;
    private MoviesPresenter moviesPresenter;
    private RecyclerView.LayoutManager lManager;
    private DividerItemDecoration divider;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        moviesPresenter = new MoviesPresenter(this);
        moviesPresenter.getMovies();

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this,
                R.array.listaOpciones, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getSelectedItem().toString().equals("--Por Puntuacion--")){
                    Intent navegar = new Intent(getBaseContext(), FilterMoviesActivity.class);
                    navegar.putExtra("opcion", 1);
                    spinner.setSelection(0);
                    startActivity(navegar);
                }
                else if (parent.getSelectedItem().toString().equals("--Por Votos--")){
                    Intent navegar2 = new Intent(getBaseContext(), FilterMoviesActivity.class);
                    spinner.setSelection(0);
                    startActivity(navegar2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void success(ArrayList<Movie> movies) {
        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.rvLista);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        // 1º) Tipo Lista
        // 2º) Tipo Grid
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
        // Crear un nuevo adaptador
        // adapter = new AdapterMovie(movies);
        //recycler.setAdapter(adapter);
        ListAdapter listAdapter = new ListAdapter(movies);
        divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recycler.addItemDecoration(divider);
        recycler.setAdapter(listAdapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
