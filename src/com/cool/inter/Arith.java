package com.cool.inter;

import com.cool.lexer.*;
import com.cool.symbols.*;

public class Arith extends Op {
    private Expr expr1, expr2;

    public Arith(Token tok, Expr x1, Expr x2) {
        super(tok, null);
        expr1 = x1;
        expr2 = x2;
        type = Type.max(expr1.type, expr2.type);
        if (type == null) {
            error("type error");
        }
    }

    public Expr gen() {
        return new Arith(token, expr1.reduce(), expr2.reduce());
    }

    public String toString() {
        return expr1.toString() + " " + token.toString() + " " + expr2.toString();
    }
}
