package org.bolyuk.joghurt;

import java.util.ArrayList;
import java.util.List;

public class C {
    public static ArrayList<String> k = new ArrayList<>(List.of("new", "class", "func", "if", "else", "for", "use", "this", "return"));
    public static ArrayList<String> o = new ArrayList<>(List.of("+", "-", "/", "*",  ";", ".", ",", "="));
    public static ArrayList<String> t = new ArrayList<>(List.of("str", "int", "bool", "arr", "type", "void"));
    public static ArrayList<String> lu = new ArrayList<>(List.of("(", "{", "[" ));
    public static ArrayList<String> ld = new ArrayList<>(List.of(")", "}", "]"));

    public enum JType{
        INT, FUNC, ERR, LITERAL, OPERATOR, STATEMENT, STRUCT, TYPE, STR, UNKNOWN, KEYWORD;
    }
}
