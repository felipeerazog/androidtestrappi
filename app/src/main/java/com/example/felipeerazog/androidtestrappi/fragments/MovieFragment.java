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
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.felipeerazog.androidtestrappi.R;
import com.example.felipeerazog.androidtestrappi.adapters.MovieListViewAdapter;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;
import com.example.felipeerazog.androidtestrappi.viewmodels.MovieViewModel;

import org.w3c.dom.Text;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class MovieFragment extends Fragment {


    private static final String SECTION_NUMBER_KEY = "section_number";

    public static final String CATEGORY_KEY = "category";

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MovieViewModel viewModel;

    @BindView(R.id.movies_list)
    ListView moviesList;

    public MovieFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        ButterKnife.bind(this, view);
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
    public static MovieFragment newInstance(int sectionNumber, String category) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER_KEY, sectionNumber);
        args.putString(CATEGORY_KEY, category);
        fragment.setArguments(args);
        return fragment;
    }

    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){
        String category = getArguments().getString(CATEGORY_KEY);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel.class);
        viewModel.init(category);
        viewModel.getMovies().observe(this, movies -> updateUI(movies));
    }

    // -----------------
    // UPDATE UI
    // -----------------


    private void updateUI(@Nullable List<Movie> movies){
        if (movies != null && !movies.isEmpty()){
            //Glide.with(this).load(user.getAvatar_url()).apply(RequestOptions.circleCropTransform()).into(imageView);

            Movie[] array = movies.toArray(new Movie[movies.size()]);
            MovieListViewAdapter movieListViewAdapter = new MovieListViewAdapter(this.getContext(), array);
            moviesList.setAdapter(movieListViewAdapter);
        }
    }
}
