package com.cool;

import java.io.*;
import com.cool.lexer.*;
import com.cool.parser.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length <= 0) {
            return;
        }
        Lexer lex = new Lexer(args[0]);
        Parser parser = new Parser(lex);
        parser.program();
        System.out.write('\n');
    }
}
