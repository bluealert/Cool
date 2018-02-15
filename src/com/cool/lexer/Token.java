package com.cool.lexer;

public class Token {
    public Token(int t) {
        tag = t;
    }

    public String toString() {
        return "" + (char)tag;
    }

    public final int tag;
}
