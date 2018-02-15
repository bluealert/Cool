package com.cool.inter;

import com.cool.lexer.Token;

public class Or extends Logical {
    public Or(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2);
    }

    public void jumping(int t, int f) {
        int label = t != 0 ? t : newLabel();
        expr1.jumping(label, 0);
        expr2.jumping(t, f);
        if (t == 0) {
            emitLabel(label);
        }
    }
}
