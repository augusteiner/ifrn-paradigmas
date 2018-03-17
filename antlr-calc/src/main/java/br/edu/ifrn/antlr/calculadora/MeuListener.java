package br.edu.ifrn.antlr.calculadora;

import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
class MeuListener extends CalculadoraBaseListener implements ParseTreeListener {

    private final ParseTreeProperty<Integer> values;
    private int resultado;

    public MeuListener() {
        values = new ParseTreeProperty<Integer>();
    }

    int getPrograma() {
        return resultado;
    }

    @Override public void exitInteiro(CalculadoraParser.InteiroContext ctx) {
        System.out.println(ctx.INT().getText());

        values.put(ctx.INT(), Integer.parseInt(ctx.INT().getText()));
    }

    @Override public void exitOpBin(CalculadoraParser.OpBinContext ctx) {
        // if (ctx.children.size() != 3)
        //     return;

        // String operacao = ctx.children.get(1).getText();

        // System.out.println(ctx.children);
        // System.out.println(ctx.children.size());

        // int lhs = values.get(ctx.expressao(0));
        // int rhs = values.get(ctx.expressao(1));

        // if (operacao.equals("+")) {
        //     resultado += lhs + rhs;
        // } else if (operacao.equals("*")) {
        //     resultado += lhs * rhs;
        // } else {
        //     //
        // }
    }

}
