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

    int getResultado() {
        return resultado;
    }

    @Override
    public void exitInteiro(CalculadoraParser.InteiroContext ctx) {
        System.out.println(ctx.INT().getText());

        values.put(ctx, Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public void exitOpBin(CalculadoraParser.OpBinContext ctx) {
        if (ctx.children.size() != 3)
            return;

        String operacao = ctx.children.get(1).getText();

        Integer lhs = values.get(ctx.children.get(0));
        Integer rhs = values.get(ctx.children.get(2));

        if (operacao.equals("+")) {
            resultado = lhs + rhs;
        } else if (operacao.equals("*")) {
            resultado = lhs * rhs;
        } else {
            //
        }

        values.put(ctx, resultado);
    }

}
