package dev.joostlek.lingo.cli.connector;

import dev.joostlek.lingo.cli.domain.Word;

public interface WordOutput {
    void addWordToDictionary(Word word, String dictionaryId);
}
