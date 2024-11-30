package com.example.zadanie2;

import org.example.zadanie2.model.Paragraph;
import org.example.zadanie2.model.Sentence;
import org.example.zadanie2.model.TextProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

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
}
