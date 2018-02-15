package com.cool.lexer;

public class Num extends Token {
    public Num(int v) {
        super(Tag.NUM);
        value = v;
    }

    public String toString() {
        return "" + value;
    }

    public final int value;
}
