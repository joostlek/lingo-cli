package dev.joostlek.lingo.cli.connector.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperProvider {

    private static ObjectMapperProvider instance;

    private ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public static ObjectMapperProvider getInstance() {
        if (instance == null) {
            instance = new ObjectMapperProvider();
        }
        return instance;
    }

    public ObjectMapper mapper() {
        return objectMapper;
    }
}
