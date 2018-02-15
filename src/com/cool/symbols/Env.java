package com.cool.symbols;

import java.util.*;
import com.cool.lexer.*;
import com.cool.inter.*;

public class Env {
    private Hashtable<Token, Id> table;
    private Env prev;

    public Env(Env n) {
        table = new Hashtable<>();
        prev = n;
    }

    public void put(Token w, Id i) {
        table.put(w, i);
    }

    public Id get(Token w) {
        for (Env e = this; e != null; e = e.prev) {
            Id found = e.table.get(w);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
