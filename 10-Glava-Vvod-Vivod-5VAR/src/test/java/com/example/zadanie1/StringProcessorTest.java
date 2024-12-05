package com.example.zadanie1;

import org.example.Zadanie1.processor.StringProcessor;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    @Test
    public void testFindLongestDigitSequence_SingleLine() {
        StringProcessor processor = new StringProcessor();
        assertEquals(5, processor.findLongestDigitSequence("12345abc678"));
        assertEquals(3, processor.findLongestDigitSequence("abc123xyz"));
        assertEquals(0, processor.findLongestDigitSequence("no_digits_here"));
        assertEquals(12, processor.findLongestDigitSequence("123456789012"));
    }

    @Test
    public void testFindLongestDigitSequence_EmptyString() {
        StringProcessor processor = new StringProcessor();
        assertEquals(0, processor.findLongestDigitSequence(""));
    }

    @Test
    public void testFindLongestDigitSequence_NullString() {
        StringProcessor processor = new StringProcessor();
        assertEquals(0, processor.findLongestDigitSequence(null));
    }

    @Test
    public void testProcessFileFromResources_ValidFile() throws IOException {
        StringProcessor processor = new StringProcessor();
        int maxLength = processor.processFileFromResources("input.txt");
        assertEquals(15, maxLength);
    }

    @Test
    public void testProcessFileFromResources_FileNotFound() {
        StringProcessor processor = new StringProcessor();
        assertThrows(FileNotFoundException.class, () -> processor.processFileFromResources("nonexistent_file.txt"));
    }
}
