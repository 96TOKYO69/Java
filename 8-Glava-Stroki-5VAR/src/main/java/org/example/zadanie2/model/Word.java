package org.example.zadanie2.model;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private List<Symbol> symbols;

    public Word(String word) {
        symbols = new ArrayList<>();
        for (char c : word.toCharArray()) {
            symbols.add(new Symbol(c));
        }
    }

    @Override
    public String toString() {
        return symbols.stream()
                .map(symbol -> String.valueOf(symbol.getValue()))
                .reduce("", String::concat);
    }
}
