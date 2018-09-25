package com.example.felipeerazog.androidtestrappi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.felipeerazog.androidtestrappi.R;
import com.example.felipeerazog.androidtestrappi.database.entities.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_title)
    TextView title;

    @BindView(R.id.detail_overview)
    TextView overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Movie movie = (Movie) getIntent().getExtras().getSerializable("movie");

        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());
    }
}
