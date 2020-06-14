package dev.joostlek.lingo.cli.application;

import dev.joostlek.lingo.cli.domain.Word;

public interface WordService {
    Word addWordToDictionary(String word, String dictionaryId);
}
