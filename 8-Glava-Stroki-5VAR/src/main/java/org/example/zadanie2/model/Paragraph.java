package org.example.zadanie2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Paragraph {
    private List<Sentence> sentences;

    public Paragraph(String paragraph) {
        sentences = new ArrayList<>();
        String[] sentenceTokens = paragraph.split("(?<=[.!?])\\s+");
        for (String sentenceToken : sentenceTokens) {
            sentences.add(new Sentence(sentenceToken));
        }
    }

    public void processSentences() {
        sentences.forEach(Sentence::swapFirstAndLastWords);
    }

    @Override
    public String toString() {
        return sentences.stream()
                .map(Sentence::toString)
                .collect(Collectors.joining(" "))
                .trim() + "\n";
    }
}
