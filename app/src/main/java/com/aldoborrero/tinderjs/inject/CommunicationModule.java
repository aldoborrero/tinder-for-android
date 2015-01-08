package com.aldoborrero.tinderjs.inject;

import com.aldoborrero.tinderjs.ui.TinderJsApplication;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import timber.log.Timber;

@Module
public class CommunicationModule {

    private static final int CACHE_SIZE = 50 * 1024 * 1024;

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(TinderJsApplication application) {
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
    public Picasso providePicasso(TinderJsApplication application, OkHttpClient okHttpClient) {
        return new Picasso.Builder(application)
                .downloader(new OkHttpDownloader(okHttpClient))
                .indicatorsEnabled(true)
                .build();
    }

}
