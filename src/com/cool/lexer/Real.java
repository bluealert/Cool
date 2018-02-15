package com.cool.lexer;

public class Real extends Token {
    Real(float v) {
        super(Tag.REAL);
        value = v;
    }

    public String toString() {
        return "" + value;
    }

    private final float value;
}
