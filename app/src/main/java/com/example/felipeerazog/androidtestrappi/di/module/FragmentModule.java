package com.example.felipeerazog.androidtestrappi.di.module;

import com.example.felipeerazog.androidtestrappi.fragments.MovieFragment;
import com.example.felipeerazog.androidtestrappi.fragments.PopularFragment;
import com.example.felipeerazog.androidtestrappi.fragments.TopRatedFragment;
import com.example.felipeerazog.androidtestrappi.fragments.UpcomingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract MovieFragment contributeMovieFragment();

    @ContributesAndroidInjector
    abstract PopularFragment contributePopularFragment();

    @ContributesAndroidInjector
    abstract TopRatedFragment contributeTopRatedFragment();

    @ContributesAndroidInjector
    abstract UpcomingFragment contributeUpcomingFragment();
}
