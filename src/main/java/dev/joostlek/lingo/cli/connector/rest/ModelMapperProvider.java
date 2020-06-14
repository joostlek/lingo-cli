package dev.joostlek.lingo.cli.connector.rest;

import okhttp3.OkHttpClient;
import org.modelmapper.ModelMapper;

public class ModelMapperProvider {

    private static ModelMapperProvider instance;

    private ModelMapper modelMapper;

    public ModelMapperProvider() {
        this.modelMapper = new ModelMapper();
    }

    public static ModelMapperProvider getInstance() {
        if (instance == null) {
            instance = new ModelMapperProvider();
        }
        return instance;
    }

    public ModelMapper modelMapper() {
        return modelMapper;
    }
}
