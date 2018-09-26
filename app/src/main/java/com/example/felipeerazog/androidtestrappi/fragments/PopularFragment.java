package com.example.felipeerazog.androidtestrappi.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

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

public class PopularFragment extends Fragment{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MovieViewModel viewModel;

    @BindView(R.id.popular_list)
    ListView moviesList;

    @BindView(R.id.search_popular)
    SearchView search;

    private static final String CATEGORY = "popular";

    MovieListViewAdapter movieListViewAdapter;

    public PopularFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        ButterKnife.bind(this, view);

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

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();
        this.configureViewModel();
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    /*public static PopularFragment newInstance(int sectionNumber, String category) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER_KEY, sectionNumber);
        args.putString(CATEGORY_KEY, category);
        fragment.setArguments(args);
        return fragment;
    }*/

    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel.class);

        viewModel.init(CATEGORY, getContext());
        viewModel.getMovies().observe(this, movies -> updateUI(movies));
    }

    // -----------------
    // UPDATE UI
    // -----------------


    private void updateUI(@Nullable List<Movie> movies){
        if (movies != null && !movies.isEmpty()){
            //Glide.with(this).load(user.getAvatar_url()).apply(RequestOptions.circleCropTransform()).into(imageView);

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
        }
    }
}
