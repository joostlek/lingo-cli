package dev.joostlek.lingo.cli.connector.rest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WebConnector {
    public void test() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.lingo.joostlek.dev/api/v1/dictionaries")
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
