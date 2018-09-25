package com.example.felipeerazog.androidtestrappi.di.module;

import com.example.felipeerazog.androidtestrappi.fragments.MovieFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract MovieFragment contributeUserProfileFragment();
}
