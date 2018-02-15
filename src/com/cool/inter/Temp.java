package com.cool.inter;

import com.cool.lexer.*;
import com.cool.symbols.*;

public class Temp extends Expr {
    private static int count = 0;
    private int number = 0;

    Temp(Type p) {
        super(Word.temp, p);
        number = ++count;
    }
    public String toString() {
        return "t" + number;
    }
}
