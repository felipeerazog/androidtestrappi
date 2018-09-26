package com.example.felipeerazog.androidtestrappi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.felipeerazog.androidtestrappi.R;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieListViewAdapter extends ArrayAdapter<Movie> implements Filterable{

    private final Context context;
    private Movie[] movies;
    CustomFilter filter;
    private Movie[] filterMovies;

    public MovieListViewAdapter(@NonNull Context context, Movie[] movies) {
        super(context, -1, movies);
        this.context = context;
        this.movies = movies;
        filterMovies = movies;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return movies.length;
    }

    @Override
    public Movie getItem(int pos) {
        // TODO Auto-generated method stub
        return movies[pos];
    }

    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return movies[pos].getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent){
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_movies, parent, false);
        }
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(movies[i].getTitle());
        TextView overview = (TextView) view.findViewById(R.id.overview);
        overview.setText(movies[i].getOverview());

        return view;
    }

    @Override
    public Filter getFilter() {
        // TODO Auto-generated method stub
        if(filter == null)
        {
            filter=new CustomFilter();
        }

        return filter;
    }

    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length()>0) {
                String filterString = constraint.toString().toLowerCase();
                ArrayList<Movie> moviesFound = new ArrayList<Movie>();

                for (int i = 0; i < filterMovies.length; i++) {
                    if (filterMovies[i].getTitle().toLowerCase().contains(filterString)) {
                        moviesFound.add(filterMovies[i]);
                    }
                }

                results.values = moviesFound.toArray(new Movie[moviesFound.size()]);
                results.count = moviesFound.size();
            }
            else{
                results.values = filterMovies;
                results.count = filterMovies.length;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movies = (Movie[]) results.values;
            notifyDataSetChanged();
        }

    }


}
