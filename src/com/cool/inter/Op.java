package com.cool.inter;

import com.cool.lexer.Token;
import com.cool.symbols.Type;

public class Op extends Expr {
    Op(Token tok, Type p) {
        super(tok, p);
    }

    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(type);
        emit(t.toString() + " = " + x.toString());
        return t;
    }
}
