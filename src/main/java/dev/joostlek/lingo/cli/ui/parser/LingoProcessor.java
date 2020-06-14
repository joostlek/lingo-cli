package dev.joostlek.lingo.cli.ui.parser;

import dev.joostlek.lingo.cli.LingoLexer;
import dev.joostlek.lingo.cli.LingoParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class LingoProcessor {

    private final LingoController listener;

    public LingoProcessor(LingoController listener) {
        this.listener = listener;
    }

    public void parse(String command) {
        Lexer lexer = new LingoLexer(CharStreams.fromString(command));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        LingoParser parser = new LingoParser(tokens);
        parser.setErrorHandler(new DefaultErrorStrategy()
        {
            @Override
            public void recover(Parser recognizer, RecognitionException e) {
                for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
                    context.exception = e;
                }

                throw new ParseCancellationException(e);
            }
        });
        ParseTree tree = parser.command();

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(this.listener, tree);
    }
}
