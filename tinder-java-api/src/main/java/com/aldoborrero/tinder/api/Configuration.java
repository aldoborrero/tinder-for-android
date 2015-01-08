package com.aldoborrero.tinder.api;

public interface Configuration {

    public static Configuration ANDROID = new Configuration() {

        @Override
        public String getAuthToken() {
            return null;
        }

        @Override
        public String getUserAgent() {
            return null;
        }

        @Override
        public String getOsVersion() {
            return null;
        }

        @Override
        public String getAppVersion() {
            return null;
        }

        @Override
        public String getPlatform() {
            return "android";
        }

    };

    String getAuthToken();
    String getUserAgent();
    String getOsVersion();
    String getAppVersion();
    String getPlatform();

}
