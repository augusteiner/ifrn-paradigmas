package br.edu.ifrn.whilelang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

class App {
    public static void main(String[] args) {
        String programa =
              "x := 10; y := leia; c:= x + y;"
            + "se 30 <= c entao escreva c senao exiba \"menor\"";

        final ParseTree tree = parse(programa);
        final ParseTreeWalker walker = new ParseTreeWalker();
        final WhilelangListener listener = new DefaultListener();

        walker.walk(listener, tree);
    }

    private static ParseTree parse(String programa) {
        final CharStream stream = CharStreams.fromString(programa);
        final WhilelangLexer lexer = new WhilelangLexer(stream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final WhilelangParser parser = new WhilelangParser(tokens);

        return parser.programa();
    }
}
