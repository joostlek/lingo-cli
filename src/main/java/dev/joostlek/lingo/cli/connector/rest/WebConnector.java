package dev.joostlek.lingo.cli.connector.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class WebConnector {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static <D> D doPost(String endpoint, Object bodyObject, Class<D> returnObject) throws IOException {
        String bodyString = ObjectMapperProvider.getInstance().mapper().writer().writeValueAsString(bodyObject);

        RequestBody body = RequestBody.create(bodyString, JSON);

        Request request = new Request.Builder()
                .url("https://api.lingo.joostlek.dev/api/v1" + endpoint)
                .post(body)
                .build();

        Response response = HttpClientProvider
                .getInstance()
                .client()
                .newCall(request)
                .execute();

        String responseString = Objects.requireNonNull(response.body()).string();

        Map<String, Object> responseMap = ObjectMapperProvider.getInstance().mapper().readerFor(Map.class).readValue(responseString);

        if (!response.isSuccessful()) {
            throw new IOException((String) responseMap.get("error"));
        }

        return ModelMapperProvider.getInstance().modelMapper().map(responseMap.get("data"), returnObject);
    }
}
