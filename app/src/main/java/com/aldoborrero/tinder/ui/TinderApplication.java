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
