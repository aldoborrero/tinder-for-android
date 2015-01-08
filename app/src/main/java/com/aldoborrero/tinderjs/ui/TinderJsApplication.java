package com.aldoborrero.tinderjs.ui;

import android.app.Application;

import com.aldoborrero.tinderjs.BuildConfig;
import com.aldoborrero.tinderjs.inject.TinderJsApplicationComponent;

import timber.log.Timber;

public class TinderJsApplication extends Application {

    private TinderJsApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initTimber();
        initCrashlytics();
    }

    private void initDagger() {
        applicationComponent = TinderJsApplicationComponent.Initializer.init(this);
    }

    private void initTimber() {
        Timber.plant(BuildConfig.DEBUG ? new Timber.DebugTree() : new Timber.HollowTree());
    }

    private void initCrashlytics() {

    }

    public TinderJsApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
