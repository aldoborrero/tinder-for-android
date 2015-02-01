package com.aldoborrero.tinder.ui;

import android.app.Application;

import com.aldoborrero.tinder.BuildConfig;
import com.aldoborrero.tinder.inject.ApplicationModuleProvider;
import com.aldoborrero.tinder.inject.Injector;
import com.aldoborrero.tinder.inject.ObjectGraphProvider;

import dagger.ObjectGraph;
import timber.log.Timber;

public class TinderApplication extends Application implements Injector, ObjectGraphProvider {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initTimber();
        initCrashlytics();
    }

    private void initDagger() {
        objectGraph = ObjectGraph.create(ApplicationModuleProvider.from(this).getModules());
        inject(this);
    }

    private void initTimber() {
        Timber.plant(BuildConfig.DEBUG ? new Timber.DebugTree() : new Timber.HollowTree());
    }

    private void initCrashlytics() {
    }

    @Override
    public void inject(Object o) {
        objectGraph.inject(o);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
    
}
