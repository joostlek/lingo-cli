package dev.joostlek.lingo.cli.ui.parser;

import dev.joostlek.lingo.cli.LingoBaseListener;
import dev.joostlek.lingo.cli.LingoParser;
import dev.joostlek.lingo.cli.application.WordApplicationService;

import java.util.logging.Logger;


public class LingoController extends LingoBaseListener {

    private static final Logger logger = Logger.getLogger("LingoController");

    private final WordApplicationService wordApplicationService;

    public LingoController(WordApplicationService wordApplicationService) {
        this.wordApplicationService = wordApplicationService;
    }

    @Override
    public void enterCommandAddWord(LingoParser.CommandAddWordContext ctx) {
        String dictionary = ctx.DICTIONARY().getText();
        String word = ctx.WORD().getText();
        logger.info(String.format("Adding %s to %s.", word, dictionary));
        String wordId = wordApplicationService.addWordToDictionary(word, dictionary);
        logger.info(String.format("Added %s to %s. The identifier is %s.", word, dictionary, wordId));
    }

    @Override
    public void enterCommandAddDictionary(LingoParser.CommandAddDictionaryContext ctx) {
        System.out.println("kekekekke");
    }
}
