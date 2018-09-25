package com.example.felipeerazog.androidtestrappi.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.felipeerazog.androidtestrappi.R;
import com.example.felipeerazog.androidtestrappi.adapters.MovieListViewAdapter;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;
import com.example.felipeerazog.androidtestrappi.viewmodels.MovieViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class TopRatedFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MovieViewModel viewModel;

    @BindView(R.id.toprated_list)
    ListView moviesList;

    private static final String CATEGORY = "top_rated";

    public TopRatedFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toprated, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();
        this.configureViewModel();
    }

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel.class);
        viewModel.init(CATEGORY);
        viewModel.getMovies().observe(this, movies -> updateUI(movies));
    }

    private void updateUI(@Nullable List<Movie> movies){
        if (movies != null && !movies.isEmpty()){
            Movie[] array = movies.toArray(new Movie[movies.size()]);
            MovieListViewAdapter movieListViewAdapter = new MovieListViewAdapter(this.getContext(), array);
            moviesList.setAdapter(movieListViewAdapter);
        }
    }
}
