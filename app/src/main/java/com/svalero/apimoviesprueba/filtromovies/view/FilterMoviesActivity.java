package com.svalero.apimoviesprueba.filtromovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.filtromovies.adapter.FilterAdapter;
import com.svalero.apimoviesprueba.filtromovies.contract.FilterMoviesContract;
import com.svalero.apimoviesprueba.filtromovies.presenter.FilterMoviesPresenter;
import com.svalero.apimoviesprueba.movies.adapter.ListAdapter;
import com.svalero.apimoviesprueba.movies.presenter.MoviesPresenter;

import java.util.ArrayList;

public class FilterMoviesActivity extends AppCompatActivity implements FilterMoviesContract.View {

    private RecyclerView recyclerFilter;
    private RecyclerView.LayoutManager lManagerFilter;
    private FilterMoviesPresenter filterMoviesPresenter;
    private int opcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_movies);

        filterMoviesPresenter = new FilterMoviesPresenter(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            opcion = bundle.getInt("opcion", 1);
        }

        if(opcion == 1) {
            filterMoviesPresenter.getMoviesFilterPuntos();
        } else {
            filterMoviesPresenter.getMoviesFilterVotos();
        }

    }

    @Override
    public void successPuntos(ArrayList<Movie> moviesPuntos) {
        recyclerFilter = (RecyclerView) findViewById(R.id.recyclerFilterMovies);
        recyclerFilter.setHasFixedSize(true);

        lManagerFilter = new LinearLayoutManager(this);
        recyclerFilter.setLayoutManager(lManagerFilter);

        FilterAdapter filterAdapter = new FilterAdapter(moviesPuntos);

        recyclerFilter.setAdapter(filterAdapter);
    }

    @Override
    public void successVotos(ArrayList<Movie> moviesVotos) {
        recyclerFilter = (RecyclerView) findViewById(R.id.recyclerFilterMovies);
        recyclerFilter.setHasFixedSize(true);

        lManagerFilter = new LinearLayoutManager(this);
        recyclerFilter.setLayoutManager(lManagerFilter);

        FilterAdapter filterAdapter = new FilterAdapter(moviesVotos);

        recyclerFilter.setAdapter(filterAdapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}

/*for (int i = 0; i < 10; i++) {
            System.out.println(Movie.getListaFilterVotos().get(i).getVotos());
        }*/