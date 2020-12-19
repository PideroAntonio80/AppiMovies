package com.svalero.apimoviesprueba.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.svalero.apimoviesprueba.R;
import com.svalero.apimoviesprueba.beans.Movie;
import com.svalero.apimoviesprueba.onemovie.view.OneMovieActivity;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MovieViewHolder> {
    private ArrayList<Movie> lstMovies;

    /*Tantos elementos como objetos quiera mostrar en la fila*/
    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView img;
        public TextView titulo;
        public TextView fecha;
        public Context context;
        public LinearLayout rowList;

        public MovieViewHolder(View v){
            super(v);
            context = v.getContext();
            rowList = v.findViewById(R.id.rowList);
            img = (ImageView) v.findViewById(R.id.imgMovie);
            titulo = (TextView) v.findViewById(R.id.txtTitulo);
            fecha = (TextView) v.findViewById(R.id.txtFecha);
            v.setOnClickListener(this);
        }

        /*void setOnClickListeners() {
            rowList.setOnClickListener(this);
        }*/

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, OneMovieActivity.class);
            intent.putExtra("titulo", titulo.getText());
            intent.putExtra("fecha", fecha.getText());
            context.startActivity(intent);
        }
    }

    public ListAdapter(ArrayList<Movie> lstMovies) {
        this.lstMovies = lstMovies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent,false);

        return new MovieViewHolder(v);
    }
    //ListAdapter.   <-- Estaba antes de MovieViewHolder (linea 47)
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        // Enlace=pintado
        // holder.img
        // Vídeo de Picasso o Glide
        Movie movie = lstMovies.get(position);
        Picasso.get().load(movie.getImage()).into(holder.img);
        holder.titulo.setText(movie.getTitulo());
        holder.fecha.setText(movie.getFecha());
        //-->holder.setOnClickListeners();

        //----------------------------------------------------------
        //holder.vote.setText(movie.getVote());
        // Picasso.with(context).load(movie.getImage()).into(holder.img);
        //----------------------------------------------------------


    }

    @Override
    public int getItemCount() {
        return lstMovies.size();
    }
}
