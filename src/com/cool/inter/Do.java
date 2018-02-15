package com.cool.inter;

import com.cool.symbols.*;

public class Do extends Stmt {
    Expr expr;
    private Stmt stmt;

    public Do() {
        expr = null;
        stmt = null;
    }

    public void init(Stmt s, Expr x) {
        expr = x;
        stmt = s;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in do");
        }
    }

    public void gen(int b, int a) {
        after = a;
        int label = newLabel();
        stmt.gen(b, label);
        emitLabel(label);
        expr.jumping(b, 0);
    }
}
