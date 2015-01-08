package com.aldoborrero.tinder.api;

import com.aldoborrero.tinder.api.services.TinderService;
import com.google.gson.GsonBuilder;

import retrofit.Endpoint;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class Tinder {

    private static final String AUTH_TOKEN_HEADER = "X-Auth-Token";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String OS_VERSION_HEADER = "os-version";
    private static final String APP_VERSION_HEADER = "app-version";
    private static final String PLATFORM_HEADER = "platform";

    private RestAdapter restAdapter;
    private Endpoint endpoint;
    private Configuration configuration;

    public Tinder(EndpointType endpointType, Configuration configuration) {
        this.endpoint = endpointType.endpoint;
        this.configuration = configuration;
    }

    public Tinder(Configuration configuration) {
        this(EndpointType.PRODUCTION, configuration);
    }

    protected RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(endpoint)
                    .setConverter(new GsonConverter(new GsonBuilder().create()))
                    .setRequestInterceptor(new RequestInterceptor() {
                        @Override
                        public void intercept(RequestFacade requestFacade) {
                            requestFacade.addHeader(AUTH_TOKEN_HEADER, configuration.getAuthToken());
                            requestFacade.addHeader(USER_AGENT_HEADER, configuration.getUserAgent());
                            requestFacade.addHeader(OS_VERSION_HEADER, configuration.getOsVersion());
                            requestFacade.addHeader(APP_VERSION_HEADER, configuration.getAppVersion());
                            requestFacade.addHeader(PLATFORM_HEADER, configuration.getPlatform());
                        }
                    }).build();
        }

        return restAdapter;
    }

    public TinderService createTinderService() {
        return getRestAdapter().create(TinderService.class);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public enum EndpointType {
        PRODUCTION(new ProductionEndpoint()),
        DEVELOPMENT(new DevelopmentEndpoint());

        private Endpoint endpoint;

        EndpointType(Endpoint endpoint) {
            this.endpoint = endpoint;
        }
    }

    private static class ProductionEndpoint implements Endpoint {

        @Override
        public String getUrl() {
            return "https://api.gotinder.com";
        }

        @Override
        public String getName() {
            return "Production";
        }

    }

    private static class DevelopmentEndpoint implements Endpoint {

        @Override
        public String getUrl() {
            return "https://api.gotinder.dev";
        }

        @Override
        public String getName() {
            return "Development";
        }

    }

}
