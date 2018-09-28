package com.example.felipeerazog.androidtestrappi.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.felipeerazog.androidtestrappi.R;
import com.example.felipeerazog.androidtestrappi.activities.DetailActivity;
import com.example.felipeerazog.androidtestrappi.adapters.MovieListViewAdapter;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;
import com.example.felipeerazog.androidtestrappi.viewmodels.MovieViewModel;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class UpcomingFragment extends MovieFragment {

    @BindView(R.id.upcoming_list)
    ListView moviesList;

    @BindView(R.id.search_upcoming)
    SearchView search;

    public UpcomingFragment() {
        CATEGORY = "upcoming";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    protected void updateUI(@Nullable List<Movie> movies){
        super.updateUI(movies);
        if (movies != null && !movies.isEmpty() && movieListViewAdapter == null){

            Movie[] array = movies.toArray(new Movie[movies.size()]);

            movieListViewAdapter = new MovieListViewAdapter(this.getContext(), array);
            moviesList.setAdapter(movieListViewAdapter);
            moviesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    intent.putExtra("movie", (Serializable) array[i]);
                    startActivity(intent);
                }
            });

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    movieListViewAdapter.getFilter().filter(s);
                    return false;
                }
            });
        }
    }
}
