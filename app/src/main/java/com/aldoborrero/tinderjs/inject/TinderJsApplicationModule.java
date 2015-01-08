package com.aldoborrero.tinderjs.inject;

import com.aldoborrero.tinderjs.ui.TinderJsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TinderJsApplicationModule {

    private final TinderJsApplication application;

    public TinderJsApplicationModule(TinderJsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public TinderJsApplication provideTinderJsApplication() {
        return this.application;
    }

}
