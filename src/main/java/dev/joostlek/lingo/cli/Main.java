package dev.joostlek.lingo.cli;

import dev.joostlek.lingo.cli.connector.rest.WebConnector;
import dev.joostlek.lingo.cli.connector.rest.output.WebWordOutput;
import dev.joostlek.lingo.cli.domain.Word;

public class Main {

    public static void main(String[] args) {
        WebWordOutput webWordOutput = new WebWordOutput();
        webWordOutput.addWordToDictionary(new Word("hallo"), "1");
    }
}
