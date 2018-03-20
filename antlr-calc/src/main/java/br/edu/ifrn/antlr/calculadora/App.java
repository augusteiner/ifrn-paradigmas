package br.edu.ifrn.antlr.calculadora;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class App {
    private static ParseTree parse(String programa) {
        final CharStream input = CharStreams.fromString(programa);
        final CalculadoraLexer lexer = new CalculadoraLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final CalculadoraParser parser = new CalculadoraParser(tokens);
        return parser.expressao();
    }

    public static void main(String[] args) throws IOException {
        String programa = "2 + 3 * 4";
        final ParseTree tree = parse(programa);
        final ParseTreeWalker walker = new ParseTreeWalker();
        final MeuListener listener = new MeuListener();
        walker.walk(listener, tree);

        int p1 = listener.getResultado();
        System.out.println(String.format("O resultado é: %s", p1));
    }
}
