package com.svalero.apimoviesprueba.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.onemovie.view.OneMovieActivity;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder>{
    private ArrayList<Movie> lstMoviesFilter;

    public static class FilterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imgF;
        public TextView tituloF;
        public TextView fechaF;
        public TextView puntos;
        public TextView votos;
        public Context context;
        public CardView row;

        public Movie myMovie;

        public FilterViewHolder(View v) {
            super(v);
            context = v.getContext();
            row = v.findViewById(R.id.rowFilterCard);
            imgF = (ImageView) v.findViewById(R.id.imgMovieFilter);
            tituloF = (TextView) v.findViewById(R.id.txtTituloFilter);
            fechaF = (TextView) v.findViewById(R.id.txtFechaFilter);
            puntos = (TextView) v.findViewById(R.id.txtPuntos);
            votos = (TextView) v.findViewById(R.id.txtVotos);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, OneMovieActivity.class);
            intent.putExtra("my_movie", myMovie);
            context.startActivity(intent);
        }
    }

    public FilterAdapter(ArrayList<Movie> lstMoviesFilter) {
        this.lstMoviesFilter = lstMoviesFilter;
    }


    @NonNull
    @Override
    public FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_filter_card, parent,false);
        return new FilterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterViewHolder holder, int position) {
        String urlBase = "https://image.tmdb.org/t/p/original";

        Movie movie = lstMoviesFilter.get(position);

        Picasso.get().load(urlBase + movie.getImage()).into(holder.imgF);
        holder.tituloF.setText(movie.getTitulo());
        holder.fechaF.setText(movie.getFecha());
        holder.puntos.setText(movie.getPuntos());
        holder.votos.setText(String.valueOf(movie.getVotos()));
        holder.myMovie = movie;

    }

    @Override
    public int getItemCount() {
        return lstMoviesFilter.size();
    }

}
