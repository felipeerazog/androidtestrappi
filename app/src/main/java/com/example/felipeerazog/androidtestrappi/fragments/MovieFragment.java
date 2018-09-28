package com.example.felipeerazog.androidtestrappi.fragments;

import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class MovieFragment extends Fragment{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MovieViewModel viewModel;

    protected String CATEGORY = "popular";

    MovieListViewAdapter movieListViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        viewModel.init(CATEGORY, getContext());
        viewModel.getMovies().observe(this, movies -> updateUI(movies));
    }

    protected void updateUI(@Nullable List<Movie> movies){

    }
}
