package dev.joostlek.lingo.cli.connector.rest.output;

import dev.joostlek.lingo.cli.connector.WordOutput;
import dev.joostlek.lingo.cli.connector.rest.ModelMapperProvider;
import dev.joostlek.lingo.cli.connector.rest.WebConnector;
import dev.joostlek.lingo.cli.connector.rest.dto.WordDto;
import dev.joostlek.lingo.cli.domain.Word;
import okhttp3.*;

import java.io.IOException;

public class WebWordOutput implements WordOutput {

    @Override
    public String addWordToDictionary(Word word, String dictionaryId) throws IOException {
        WordDto wordDto = ModelMapperProvider.getInstance().modelMapper().map(word, WordDto.class);
        WordDto returnedDto = WebConnector.doPost("/dictionaries/" + dictionaryId + "/words", wordDto, WordDto.class);
        return returnedDto.getWordId();
    }
}
