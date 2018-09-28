package com.example.felipeerazog.androidtestrappi.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.felipeerazog.androidtestrappi.database.entities.Movie;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MovieDao {

    @Insert(onConflict = REPLACE)
    void save(Movie movie);

    @Query("SELECT * FROM movie WHERE category = :category")
    LiveData<List<Movie>> load(String category);

}
