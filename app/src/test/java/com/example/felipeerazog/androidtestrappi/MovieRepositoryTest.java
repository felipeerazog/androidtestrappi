package com.example.felipeerazog.androidtestrappi;

import android.arch.lifecycle.LiveData;

import com.example.felipeerazog.androidtestrappi.api.MovieService;
import com.example.felipeerazog.androidtestrappi.database.MovieDatabase;
import com.example.felipeerazog.androidtestrappi.database.dao.MovieDao;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;
import com.example.felipeerazog.androidtestrappi.di.module.AppModule;
import com.example.felipeerazog.androidtestrappi.repositories.MovieRepository;
import com.google.gson.Gson;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Retrofit;

import static org.junit.Assert.*;


public class MovieRepositoryTest {

    @Test
    public void getPopularMoviesTest() {
        AppModule appModule = new AppModule();

        Gson gson = appModule.provideGson();
        Retrofit retrofit = appModule.provideRetrofit(gson);
        MovieService movieService = appModule.provideApiWebservice(retrofit);

        MovieDatabase movieDatabase = appModule.provideDatabase(new App());
        MovieDao movieDao = appModule.provideMovieDao(movieDatabase);

        Executor executor = appModule.provideExecutor();

        MovieRepository movieRepository = new MovieRepository(movieService,movieDao,executor);
        LiveData<List<Movie>> liveData = movieRepository.getMovies("popular");

        assertNotEquals(null, liveData);
    }

    @Test
    public void getTopRatedMoviesTest() {
        AppModule appModule = new AppModule();

        Gson gson = appModule.provideGson();
        Retrofit retrofit = appModule.provideRetrofit(gson);
        MovieService movieService = appModule.provideApiWebservice(retrofit);

        MovieDatabase movieDatabase = appModule.provideDatabase(new App());
        MovieDao movieDao = appModule.provideMovieDao(movieDatabase);

        Executor executor = appModule.provideExecutor();

        MovieRepository movieRepository = new MovieRepository(movieService,movieDao,executor);
        LiveData<List<Movie>> liveData = movieRepository.getMovies("top_rated");

        assertNotEquals(null, liveData);
    }

    @Test
    public void getUpcomingMoviesTest() {
        AppModule appModule = new AppModule();

        Gson gson = appModule.provideGson();
        Retrofit retrofit = appModule.provideRetrofit(gson);
        MovieService movieService = appModule.provideApiWebservice(retrofit);

        MovieDatabase movieDatabase = appModule.provideDatabase(new App());
        MovieDao movieDao = appModule.provideMovieDao(movieDatabase);

        Executor executor = appModule.provideExecutor();

        MovieRepository movieRepository = new MovieRepository(movieService,movieDao,executor);
        LiveData<List<Movie>> liveData = movieRepository.getMovies("upcoming");

        assertNotEquals(null, liveData);
    }
}
