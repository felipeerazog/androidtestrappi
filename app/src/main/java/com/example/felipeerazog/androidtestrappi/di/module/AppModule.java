package com.example.felipeerazog.androidtestrappi.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.felipeerazog.androidtestrappi.api.MovieService;
import com.example.felipeerazog.androidtestrappi.database.MovieDatabase;
import com.example.felipeerazog.androidtestrappi.database.dao.MovieDao;
import com.example.felipeerazog.androidtestrappi.repositories.MovieRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    // --- DATABASE INJECTION ---

    @Provides
    @Singleton
    MovieDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                MovieDatabase.class, "MyDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    MovieDao provideMovieDao(MovieDatabase database) { return database.movieDao(); }

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(MovieService movieService, MovieDao movieDao, Executor executor) {
        return new MovieRepository(movieService, movieDao, executor);
    }

    // --- NETWORK INJECTION ---

    private static String BASE_URL = "https://api.themoviedb.org/3/";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    MovieService provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(MovieService.class);
    }
}

