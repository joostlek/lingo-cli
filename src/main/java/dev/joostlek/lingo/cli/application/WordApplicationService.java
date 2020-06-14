package dev.joostlek.lingo.cli.application;

import dev.joostlek.lingo.cli.connector.WordOutput;
import dev.joostlek.lingo.cli.domain.Word;

public class WordApplicationService implements WordService {

    private final WordOutput wordOutput;

    public WordApplicationService(WordOutput wordOutput) {
        this.wordOutput = wordOutput;
    }

    @Override
    public Word addWordToDictionary(String word, String dictionaryId) {
        return null;
    }
}
