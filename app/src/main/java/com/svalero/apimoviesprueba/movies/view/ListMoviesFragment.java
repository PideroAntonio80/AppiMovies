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
import com.svalero.apimoviesprueba.movies.adapter.ListAdapter;

import java.util.ArrayList;

public class ListMoviesFragment extends Fragment {

    private View view;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private DividerItemDecoration divider;
    private ArrayList<Movie> movies;

    private static final String EXTRA_LIST = "param1";

    public ListMoviesFragment() {
    }

    public static ListMoviesFragment newInstance(ArrayList<Movie> movies) {
        ListMoviesFragment fragment = new ListMoviesFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_LIST, movies);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movies = (ArrayList<Movie>) getArguments().getSerializable(EXTRA_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_movies, container, false);

        initComponents();

        loadData(movies);

        return view;
    }

    public void initComponents() {
        recycler = view.findViewById(R.id.rvLista);
    }

    public void loadData(ArrayList<Movie> movies) {
        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(lManager);

        ListAdapter listAdapter = new ListAdapter(movies);
        listAdapter.notifyDataSetChanged();
        divider = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recycler.addItemDecoration(divider);
        recycler.setAdapter(listAdapter);
    }
}