package com.cool.inter;

import com.cool.lexer.*;
import com.cool.symbols.*;

public class Id extends Expr {
    private int offset; // relative address

    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }
}
