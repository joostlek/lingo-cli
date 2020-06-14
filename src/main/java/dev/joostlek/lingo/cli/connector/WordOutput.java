package dev.joostlek.lingo.cli.connector;

import dev.joostlek.lingo.cli.domain.Word;

import java.io.IOException;

public interface WordOutput {
    String addWordToDictionary(Word word, String dictionaryId) throws IOException;
}
