package com.example.felipeerazog.androidtestrappi.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.felipeerazog.androidtestrappi.di.key.ViewModelKey;
import com.example.felipeerazog.androidtestrappi.viewmodels.FactoryViewModel;
import com.example.felipeerazog.androidtestrappi.viewmodels.MovieViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel.class)
    abstract ViewModel bindMovieViewModel(MovieViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}

