package dev.joostlek.lingo.cli.application;

import dev.joostlek.lingo.cli.domain.Word;

public interface WordService {
    String addWordToDictionary(String word, String dictionaryId);
}
