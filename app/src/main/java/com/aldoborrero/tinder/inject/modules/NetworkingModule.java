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

import com.aldoborrero.tinder.adapters.ExploreAdapter;
import com.aldoborrero.tinder.ui.TinderApplication;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module(
        injects = {
                ExploreAdapter.class
        },
        library = true,
        complete = false
)
public class NetworkingModule {

    private static final int CACHE_SIZE = 50 * 1024 * 1024;
    
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(TinderApplication application) {
        File cacheDirectory = new File(application.getCacheDir().getAbsolutePath(), "HttpCache");
        Cache cache = null;
        try {
            cache = new Cache(cacheDirectory, CACHE_SIZE);
        } catch (IOException e) {
            Timber.e(e, "Unable to initiate disk cache!");
        }
        OkHttpClient client = new OkHttpClient();
        client.setCache(cache);
        return client;
    }

    @Provides
    @Singleton
    public Picasso providePicasso(TinderApplication application, OkHttpClient okHttpClient) {
        return new Picasso.Builder(application)
                .downloader(new OkHttpDownloader(okHttpClient))
                .indicatorsEnabled(true)
                .build();
    }
    
}
