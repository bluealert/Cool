package com.cool.inter;

import com.cool.lexer.Token;

public class Not extends Logical {
    public Not(Token tok, Expr x) {
        super(tok, x, x);
    }

    public void jumping(int t, int f) {
        expr2.jumping(f, t);
    }

    public String toString() {
        return token.toString() + " " + expr2.toString();
    }
}
