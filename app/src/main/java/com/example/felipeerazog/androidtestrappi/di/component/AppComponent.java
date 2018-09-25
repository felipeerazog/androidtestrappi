package com.example.felipeerazog.androidtestrappi.di.component;

import android.app.Application;

import com.example.felipeerazog.androidtestrappi.App;
import com.example.felipeerazog.androidtestrappi.di.module.ActivityModule;
import com.example.felipeerazog.androidtestrappi.di.module.AppModule;
import com.example.felipeerazog.androidtestrappi.di.module.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);

}