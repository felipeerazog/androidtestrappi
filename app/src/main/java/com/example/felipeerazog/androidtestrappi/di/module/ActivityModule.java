package com.example.felipeerazog.androidtestrappi.di.module;

import com.example.felipeerazog.androidtestrappi.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
}
