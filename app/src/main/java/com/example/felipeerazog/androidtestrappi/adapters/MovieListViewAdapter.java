package com.example.felipeerazog.androidtestrappi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.felipeerazog.androidtestrappi.R;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;

import java.util.List;

public class MovieListViewAdapter extends ArrayAdapter<Movie> {

    private final Context context;
    private final Movie[] movies;

    public MovieListViewAdapter(@NonNull Context context, Movie[] movies) {
        super(context, -1, movies);
        this.context = context;
        this.movies = movies;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_movies, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        title.setText(movies[i].getTitle());
        TextView overview = (TextView) rowView.findViewById(R.id.overview);
        overview.setText(movies[i].getOverview());
        return rowView;
    }


}
