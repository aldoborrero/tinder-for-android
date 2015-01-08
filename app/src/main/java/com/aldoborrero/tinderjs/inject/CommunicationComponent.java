package com.aldoborrero.tinderjs.inject;

import com.aldoborrero.tinderjs.adapters.ExploreAdapter;
import com.aldoborrero.tinderjs.ui.TinderJsApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CommunicationModule.class, dependencies = TinderJsApplicationComponent.class)
public interface CommunicationComponent {

    void inject(ExploreAdapter adapter);

    public static class Initializer {

        public static CommunicationComponent init(TinderJsApplication context) {
            return Dagger_CommunicationComponent.builder()
                    .communicationModule(new CommunicationModule())
                    .tinderJsApplicationComponent(context.getApplicationComponent())
                    .build();
        }

    }

}
