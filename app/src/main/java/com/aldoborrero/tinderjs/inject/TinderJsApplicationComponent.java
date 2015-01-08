package com.aldoborrero.tinderjs.inject;

import com.aldoborrero.tinderjs.ui.TinderJsApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TinderJsApplicationModule.class})
public interface TinderJsApplicationComponent {

    public final static class Initializer {

        public static TinderJsApplicationComponent init(TinderJsApplication app) {
            return Dagger_TinderJsApplicationComponent.builder()
                    .tinderJsApplicationModule(new TinderJsApplicationModule(app))
                    .build();
        }

    }

    void inject(TinderJsApplication application);

    TinderJsApplication application();

}
