package com.example.felipeerazog.androidtestrappi.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

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

    public void init(String category) {
        if (this.movies != null) {
            return;
        }
        movies = movieRepo.getMovies(category);
    }

    public LiveData<List<Movie>> getMovies() {
        return this.movies;
    }
}
