package dev.joostlek.lingo.cli.connector.rest;

import okhttp3.OkHttpClient;

public class HttpClientProvider {

    private static HttpClientProvider instance;

    private OkHttpClient okHttpClient;

    public HttpClientProvider() {
        this.okHttpClient = new OkHttpClient();
    }

    public static HttpClientProvider getInstance() {
        if (instance == null) {
            instance = new HttpClientProvider();
        }
        return instance;
    }

    public OkHttpClient client() {
        return okHttpClient;
    }
}
