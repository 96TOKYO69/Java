package com.example.zadanie2;

import org.example.zadanie2.model.Sentence;
import org.example.zadanie2.model.TextProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    private String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    @Test
    public void testSentenceSwapFirstAndLastWordsWithPunctuation() {
        Sentence sentence = new Sentence("This is a test.");
        sentence.swapFirstAndLastWords();
        assertEquals("test is a This.", sentence.toString());
    }

    @Test
    public void testSentenceWithoutPunctuation() {
        Sentence sentence = new Sentence("This is a test");
        sentence.swapFirstAndLastWords();
        assertEquals("test is a This", sentence.toString());
    }

    @Test
    public void testSentenceWithExclamationMark() {
        Sentence sentence = new Sentence("Wow this works!");
        sentence.swapFirstAndLastWords();
        assertEquals("works this Wow!", sentence.toString());
    }

    @Test
    public void testTextLengthPreservation() {
        String originalText = """
        This is a test paragraph. It contains multiple sentences.

        Another paragraph is here. Testing continues.
        """;

        TextProcessor processor = new TextProcessor(originalText);
        processor.processText();

        String processedText = processor.toString();

        System.out.println("Original text:\n" + originalText);
        System.out.println("Processed text:\n" + processedText);
        System.out.println("Original length:" + originalText.length());
        System.out.println("Processed length:" + processedText.length());

        assertEquals(originalText.length(), processedText.length(), "Text length should remain unchanged after processing");
    }



}
