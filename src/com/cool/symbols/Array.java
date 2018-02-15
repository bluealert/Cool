package com.cool.symbols;

import com.cool.lexer.*;

public class Array extends Type {
    public Type of;
    private int size = 1;

    public Array(int sz, Type p) {
        super("[]", Tag.INDEX, sz * p.width);
        size = sz;
        of = p;
    }

    public String toString() {
        return "[" + size + "]" + of.toString();
    }
}
