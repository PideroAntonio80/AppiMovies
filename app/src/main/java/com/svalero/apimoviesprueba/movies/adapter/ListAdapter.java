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
import com.svalero.apimoviesprueba.one_movie.OneMovieActivity;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MovieViewHolder> {
    private ArrayList<Movie> lstMovies;

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView img;
        public TextView titulo;
        public TextView fecha;
        public Context context;
        public CardView rowList;

        public Movie myMovie;

        public MovieViewHolder(View v){
            super(v);
            context = v.getContext();
            rowList = v.findViewById(R.id.rowListCard);
            img = (ImageView) v.findViewById(R.id.imgMovie);
            titulo = (TextView) v.findViewById(R.id.txtTitulo);
            fecha = (TextView) v.findViewById(R.id.txtFecha);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, OneMovieActivity.class);
            intent.putExtra("my_movie", myMovie);
            context.startActivity(intent);
        }
    }

    public ListAdapter(ArrayList<Movie> lstMovies) {
        this.lstMovies = lstMovies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_card, parent,false);

        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        String urlBase = "https://image.tmdb.org/t/p/original";

        Movie movie = lstMovies.get(position);

        Picasso.get().load(urlBase + movie.getImage()).into(holder.img);
        holder.titulo.setText(movie.getTitulo());
        holder.fecha.setText(movie.getFecha());
        holder.myMovie = movie;
    }

    @Override
    public int getItemCount() {
        return lstMovies.size();
    }
}
