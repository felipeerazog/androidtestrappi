package com.example.felipeerazog.androidtestrappi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.felipeerazog.androidtestrappi.R;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    /**
     * URL for getting images
     */
    private String IMG_FOLDER_URL = "https://image.tmdb.org/t/p/w500/";

    @BindView(R.id.detail_title)
    TextView title;

    @BindView(R.id.detail_overview)
    TextView overview;

    @BindView(R.id.release_date)
    TextView releaseDate;

    @BindView(R.id.vote_average)
    RatingBar voteAverage;

    @BindView(R.id.poster)
    ImageView poster;

    @BindView(R.id.vote_average_number)
    TextView voteAverageNumber;

    /**
     * Read the movie sent via intent.
     * Loads the movie detail views with the data from Movie.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Movie movie = (Movie) getIntent().getExtras().getSerializable("movie");

        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());
        releaseDate.setText(movie.getReleaseDate());
        voteAverage.setRating((float)movie.getVoteAverage());
        voteAverage.setEnabled(false);
        voteAverageNumber.setText(String.valueOf(movie.getVoteAverage()));
        Glide.with(this).load(IMG_FOLDER_URL + movie.getPoster_path()).into(poster);

    }
}
