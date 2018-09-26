package com.example.felipeerazog.androidtestrappi.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.felipeerazog.androidtestrappi.database.entities.Movie;
import com.example.felipeerazog.androidtestrappi.repositories.MovieRepository;

import java.util.List;

import javax.inject.Inject;

public class MovieViewModel extends ViewModel {

    private LiveData<List<Movie>> movies;
    private MovieRepository movieRepo;

    @Inject
    public MovieViewModel(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    // ----

    public void init(String category, Context context) {
        if (this.movies != null) {
            return;
        }
        movies = movieRepo.getMovies(category);
    }

    public LiveData<List<Movie>> getMovies() {
        return this.movies;
    }
}
