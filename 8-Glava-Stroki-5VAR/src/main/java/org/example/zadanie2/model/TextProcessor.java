package org.example.zadanie2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextProcessor {
    private List<Paragraph> paragraphs;

    public TextProcessor(String text) {
        paragraphs = new ArrayList<>();
        String[] paragraphTokens = text.split("\\n\\s*\\n");
        for (String paragraphToken : paragraphTokens) {
            paragraphs.add(new Paragraph(paragraphToken));
        }
    }

    public void processText() {
        paragraphs.forEach(Paragraph::processSentences);
    }

    @Override
    public String toString() {
        return paragraphs.stream()
                .map(Paragraph::toString)
                .collect(Collectors.joining("\n"));
    }

}
