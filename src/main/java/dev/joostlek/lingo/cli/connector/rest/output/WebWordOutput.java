package dev.joostlek.lingo.cli.connector.rest.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dev.joostlek.lingo.cli.connector.WordOutput;
import dev.joostlek.lingo.cli.connector.rest.dto.WordDto;
import dev.joostlek.lingo.cli.domain.Word;
import okhttp3.*;
import org.modelmapper.ModelMapper;

import java.io.IOException;

public class WebWordOutput implements WordOutput {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    public void addWordToDictionary(Word word, String dictionaryId) {
        OkHttpClient client = new OkHttpClient();

        ModelMapper modelMapper = new ModelMapper();

        WordDto wordDto = modelMapper.map(word, WordDto.class);

        String bodyString = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            bodyString = objectMapper.writer().writeValueAsString(wordDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(bodyString, JSON);

        Request request = new Request.Builder()
                .url("https://api.lingo.joostlek.dev/api/v1/dictionaries/1/words")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
