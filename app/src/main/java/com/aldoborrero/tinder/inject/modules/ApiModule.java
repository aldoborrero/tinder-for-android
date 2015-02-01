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

import com.aldoborrero.tinder.api.Tinder;
import com.aldoborrero.tinder.api.entities.Auth;
import com.aldoborrero.tinder.api.interfaces.TinderErrorHandlerListener;
import com.aldoborrero.tinder.api.okhttp.interceptors.AuthTokenInterceptor;
import com.aldoborrero.tinder.api.retrofit.TinderEndpoint;
import com.aldoborrero.tinder.api.services.AuthTinderService;
import com.aldoborrero.tinder.api.services.ObservableTinderService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

@Module(
        addsTo = CommunicationModule.class,
        library = true,
        complete = true
)
public class ApiModule {

    @Provides
    @Singleton
    public Tinder provideTinder() {
        return Tinder.create()
                .setEndpoint(TinderEndpoint.PRODUCTION)
                .setAuthTokenInterceptor(new AuthTokenInterceptor() {

                    @Override
                    public Auth getAuthObject() {
                        return null;
                    }

                })
                .setErrorHandlerListener(TinderErrorHandlerListener.NONE)
                .setLog(RestAdapter.Log.NONE)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .build();
    }

    @Provides
    @Singleton
    public ObservableTinderService provideTinderService(Tinder tinder) {
        return tinder.createObservableService();
    }

    @Provides
    @Singleton
    public AuthTinderService provideAuthTinderService(Tinder tinder) {
        return tinder.createAuthTinderService();
    }
    
}
