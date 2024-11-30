package org.example.zadanie2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Word> words;
    private String punctuation = "";

    public Sentence(String sentence) {
        words = new ArrayList<>();
        // Разделяем предложение на слова и отделяем знаки препинания в конце.
        String trimmedSentence = sentence.trim();
        if (trimmedSentence.matches(".*[.!?]$")) {
            punctuation = trimmedSentence.substring(trimmedSentence.length() - 1);
            trimmedSentence = trimmedSentence.substring(0, trimmedSentence.length() - 1);
        }

        String[] wordTokens = trimmedSentence.split("\\s+");
        for (String token : wordTokens) {
            words.add(new Word(token));
        }
    }

    public void swapFirstAndLastWords() {
        if (words.size() > 1) {
            Word first = words.get(0);
            Word last = words.get(words.size() - 1);
            words.set(0, last);
            words.set(words.size() - 1, first);
        }
    }

    @Override
    public String toString() {
        // Возвращаем предложение с сохранением знака препинания.
        String sentence = words.stream()
                .map(Word::toString)
                .reduce((a, b) -> a + " " + b)
                .orElse("");
        return sentence + punctuation;
    }
}



