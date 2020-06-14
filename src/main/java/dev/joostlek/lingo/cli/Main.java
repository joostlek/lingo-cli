package dev.joostlek.lingo.cli;

import dev.joostlek.lingo.cli.application.WordApplicationService;
import dev.joostlek.lingo.cli.connector.rest.output.WebWordOutput;
import dev.joostlek.lingo.cli.ui.parser.LingoController;
import dev.joostlek.lingo.cli.ui.parser.LingoProcessor;

public class Main {

    public static void main(String[] args) {
        WordApplicationService wordApplicationService = new WordApplicationService(new WebWordOutput());
        LingoController lingoController = new LingoController(wordApplicationService);
        LingoProcessor lingoProcessor = new LingoProcessor(lingoController);
        lingoProcessor.parse(String.join(" ", args));
    }
}
