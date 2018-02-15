package com.cool.inter;

import com.cool.lexer.*;
import com.cool.symbols.*;

public class Expr extends Node {
    Token token;
    public Type type;

    Expr(Token tok, Type p) {
        token = tok;
        type = p;
    }

    public Expr gen() {
        return this;
    }

    public Expr reduce() {
        return this;
    }

    public void jumping(int t, int f) {
        emitJumps(toString(), t, f);
    }

    void emitJumps(String test, int t, int f) {
        if (t != 0 && f != 0) {
            emit("if " + test + " goto L" + t);
            emit("goto L" + f);
        } else if (t != 0) {
            emit("if " + test + " goto L" + t);
        } else if (f != 0) {
            emit("iffalse " + test + " goto L" + f);
        }
    }

    public String toString() {
        return token.toString();
    }
}
