/*
 * Copyright 2015 Aldo Borrero <aldo@aldoborrero.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
