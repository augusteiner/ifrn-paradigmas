package br.edu.ifrn.antlr.calculadora;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 */
public class App 
{
	private static ParseTree parse(String programa) {
		final ANTLRInputStream input = new ANTLRInputStream(programa);
		final CalculadoraLexer lexer = new CalculadoraLexer(input);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final CalculadoraParser parser = new CalculadoraParser(tokens);
		return parser.expressao();
	}

	public static void main(String[] args) throws IOException {
		String programa = "2 + 3 * 4";//args[0];
		final ParseTree tree = parse(programa);
		final ParseTreeWalker walker = new ParseTreeWalker();
		final MeuListener listener = new MeuListener();
		walker.walk(listener, tree);

		// int p1 = listener.getPrograma();
		// System.out.println(p1);
	}
}
