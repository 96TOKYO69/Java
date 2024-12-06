package org.example.zadanie2.model;
import java.util.ArrayList;
import java.util.List;

public class TextProcessor {
    private List<Paragraph> paragraphs;

    public TextProcessor(String text) {
        paragraphs = new ArrayList<>();
        String normalizedText = text.replaceAll("\\s+", " ");
        String[] paragraphTokens = normalizedText.split("\\n\\s*");
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
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
    }
}
