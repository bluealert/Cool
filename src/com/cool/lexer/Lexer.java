package com.cool.lexer;

import java.io.*;
import java.util.*;
import com.cool.symbols.*;

public class Lexer {
    public static int line = 1;
    private FileReader input;
    private char peek = ' ';
    private Hashtable<String, Word> words = new Hashtable<>();

    private void reserve(Word w) {
        words.put(w.lexeme, w);
    }

    public Lexer(String fileName) throws IOException {
        input = new FileReader(fileName);

        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve(Word.True);
        reserve(Word.False);
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
    }

    private void readch() throws IOException {
        peek = (char)input.read();
    }

    private boolean readch(char c) throws IOException {
        readch();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    private boolean isSpace(char c) {
        return c == ' ' || peek == '\t' || peek == '\n';
    }

    public Token scan() throws IOException {
        while (isSpace(peek)) {
            if (peek == '\n') {
                line += + 1;
            }
            readch();
        }

        switch (peek) {
            case '&':
                if (readch('&')) {
                    return Word.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Word.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readch('=')) {
                    return Word.eq;
                } else {
                    return new Token('=');
                }
            case '!':
                if (readch('=')) {
                    return Word.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readch('=')) {
                    return Word.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readch('=')) {
                    return Word.ge;
                } else {
                    return new Token('>');
                }
        }
        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));
            if (peek != '.') {
                return new Num(v);
            }
            float x = v;
            float d= 10;
            for (;;) {
                readch();
                if (!Character.isDigit(peek)) {
                    break;
                }
                x = x + Character.digit(peek, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }
        if (Character.isLetter(peek)) {
            StringBuilder b = new StringBuilder();
            do {
                b.append(peek);
                readch();
            } while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = words.get(s);
            if (w != null) {
                return w;
            }
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }
        Token tok = new Token(peek);
        peek = ' ';
        return tok;
    }
}
