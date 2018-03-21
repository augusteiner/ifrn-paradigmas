package br.edu.ifrn.whilelang;

public class Lang {
    static final Expr leia = new Leia();

    public interface Cmd {
        void execute();
    }

    public interface Expr {
        int avaliar();
    }

    class Skip implements Cmd {
        public void execute() { }
    }

    private static class Leia implements Expr {
        public int avaliar() {
            return 0;
        }
    }

    abstract class OpBin implements Expr {
        final Expr lhs, rhs;

        OpBin(Expr lhs, Expr rhs) {
            this.lhs = lhs;
            this.rhs = rhs;
        }

        public int avaliar() {
            return 0;
        }
    }

    public class ExpExpr extends OpBin {
        ExpExpr(Expr lhs, Expr rhs) {
            super(lhs, rhs);
        }

        @Override
        public int avaliar() {
            return (int) Math.pow(lhs.avaliar(), rhs.avaliar());
        }
    }

    public class DivExpr extends OpBin {
        public DivExpr(Expr lhs, Expr rhs) {
            super(lhs, rhs);
        }

        @Override
        public int avaliar() {
            return lhs.avaliar() / rhs.avaliar();
        }
    }

    public class MultExpr extends OpBin {
        public MultExpr(Expr lhs, Expr rhs) {
            super(lhs, rhs);
        }

        @Override
        public int avaliar() {
            return lhs.avaliar() * rhs.avaliar();
        }
    }
}
