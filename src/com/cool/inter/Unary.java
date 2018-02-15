package com.cool.inter;

import com.cool.lexer.Token;

public class Unary extends Op {
    public Expr expr;

    public Unary(Token tok, Expr x) {
        super(tok, null);
        expr = x;
    }

    public Expr gen() {
        return new Unary(token, expr.reduce());
    }

    public String toString() {
        return token.toString() + " " + expr.toString();
    }
}
