package com.shikhar.cinema;

import com.bumptech.glide.Glide;
import com.shikhar.cinema.model.Movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.InTheatersViewHolder> {

    private List<Movie> mInTheaterMovieList;
    private Context context;

    public static class InTheatersViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView movieName;

        public InTheatersViewHolder(View v) {
            super(v);
            poster = (ImageView) v.findViewById(R.id.poster);
            movieName = (TextView) v.findViewById(R.id.name);
        }
    }

    public MovieAdapter(List<Movie> list, Context context) {
        this.mInTheaterMovieList = list;
        this.context = context;
    }

    @Override
    public InTheatersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_intheater, parent, false);
        return new InTheatersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InTheatersViewHolder holder, final int position) {

        Glide.with(context).load(mInTheaterMovieList.get(position).getmThumbnailImage()).into(holder.poster);

        holder.movieName.setText(mInTheaterMovieList.get(position).getmName());

        holder.poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MovieDetailActivity.class);
                i.putExtra("CLICKED_MOVIE", mInTheaterMovieList.get(position)); //put the Movie object inside Intent which was clicked
                context.startActivity(i); //start a
            }
        });
    }

    @Override
    public int getItemCount() {
        return mInTheaterMovieList.size();
    }

}
