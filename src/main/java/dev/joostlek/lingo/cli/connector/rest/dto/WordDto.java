package dev.joostlek.lingo.cli.connector.rest.dto;

import lombok.Data;

@Data
public class WordDto {
    private String wordId;

    private String word;

    private String dictionaryId;
}
