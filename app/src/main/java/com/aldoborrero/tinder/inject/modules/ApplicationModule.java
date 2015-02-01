package com.aldoborrero.tinder.inject.modules;

import android.content.Context;

import com.aldoborrero.tinder.inject.qualifiers.ApplicationContext;
import com.aldoborrero.tinder.ui.TinderApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                CommunicationModule.class,
                NetworkingModule.class,
                //UiModule.class
        },
        injects = TinderApplication.class,
        library = true,
        complete = true
)
public class ApplicationModule {

    private final TinderApplication application;

    public ApplicationModule(TinderApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    TinderApplication provideTinderApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideApplicationContext() {
        return application;
    }
    
}
