package com.example.felipeerazog.androidtestrappi.api;

import com.example.felipeerazog.androidtestrappi.database.entities.MovieListInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/{category}/")
    Call<MovieListInfo> loadPopularList(@Path("category") String category, @Query("api_key") String apiKey);

}
