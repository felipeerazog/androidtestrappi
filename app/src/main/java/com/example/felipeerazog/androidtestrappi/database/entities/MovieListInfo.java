package com.example.felipeerazog.androidtestrappi.database.entities;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity
public class MovieListInfo {

    @SerializedName("page")
    private int page;

    @SerializedName("total_Movies")
    private int totalMovies;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private ArrayList<Movie> Movies;

    public MovieListInfo(){}


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Movie> getMovies() {
        return Movies;
    }

    public void setMovies(ArrayList<Movie> Movies) {
        this.Movies = Movies;
    }

    public int getTotalMovies() {
        return totalMovies;
    }

    public void setTotalMovies(int totalMovies) {
        this.totalMovies = totalMovies;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
