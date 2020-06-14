package dev.joostlek.lingo.cli.application;

import dev.joostlek.lingo.cli.connector.WordOutput;
import dev.joostlek.lingo.cli.domain.Word;

import java.io.IOException;

public class WordApplicationService implements WordService {

    private final WordOutput wordOutput;

    public WordApplicationService(WordOutput wordOutput) {
        this.wordOutput = wordOutput;
    }

    @Override
    public String addWordToDictionary(String aWord, String dictionaryId) {
        Word word = new Word(aWord);
        try {
            return wordOutput.addWordToDictionary(word, dictionaryId);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }
}
