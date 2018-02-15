package com.cool.inter;

import com.cool.lexer.Tag;
import com.cool.lexer.Word;
import com.cool.symbols.Type;

public class Access extends Op {
    Id array;
    Expr index;

    public Access(Id a, Expr i, Type p) {
        super(new Word("[]", Tag.INDEX), p);
        array = a;
        index = i;
    }

    public Expr gen() {
        return new Access(array, index.reduce(), type);
    }

    public void jumping(int t, int f) {
        emitJumps(reduce().toString(), t, f);
    }

    public String toString() {
        return array.toString() + " [ " + index.toString() + " ] ";
    }
}
