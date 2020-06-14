package dev.joostlek.lingo.cli.domain;

import lombok.Data;

@Data
public class Word {
    private String wordId;

    private String word;

    public Word(String word) {
        this.word = word;
    }
}
