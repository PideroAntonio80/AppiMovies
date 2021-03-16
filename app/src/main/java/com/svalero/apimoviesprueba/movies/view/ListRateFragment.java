package com.svalero.apimoviesprueba.movies.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.movies.adapter.FilterAdapter;

import java.util.ArrayList;

public class ListRateFragment extends Fragment {

    private View view;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private DividerItemDecoration divider;
    private ArrayList<Movie> movies;
    private ArrayList<Movie> filteredMovies;

    private static final String EXTRA_PUNTOS = "param1";

    public ListRateFragment() {
    }

    public static ListRateFragment newInstance(ArrayList<Movie> movies) {
        ListRateFragment fragment = new ListRateFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_PUNTOS, movies);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movies = (ArrayList<Movie>) getArguments().getSerializable(EXTRA_PUNTOS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_rate, container, false);

        initComponents();

        filteredMovies = Movie.getListaFilterPuntos(movies);

        loadData(filteredMovies);

        return view;
    }

    public void initComponents() {
        recycler = view.findViewById(R.id.rvListaPuntos);
    }

    public void loadData(ArrayList<Movie> movies) {
        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(lManager);

        FilterAdapter filterAdapter = new FilterAdapter(movies);
        divider = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recycler.addItemDecoration(divider);
        recycler.setAdapter(filterAdapter);
    }
}