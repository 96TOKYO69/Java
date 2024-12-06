package com.example.Zadanie3;

import org.example.Zadanie3.TextCompressor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextCompressorTest {

    @Test
    void testCompress() {
        TextCompressor compressor = new TextCompressor();

        // Тест 1: стандартный случай
        String input = "hellowoooorld";
        String expected = "hel2owo4rld";
        assertEquals(expected, compressor.compress(input));

        // Тест 2: строка без повторений
        input = "abcdef";
        expected = "abcdef";
        assertEquals(expected, compressor.compress(input));

        // Тест 3: строка с одним символом
        input = "aaaa";
        expected = "a4";
        assertEquals(expected, compressor.compress(input));

        // Тест 4: строка с разными символами и повторениями
        input = "aabcccccaaa";
        expected = "a2bc5a3";
        assertEquals(expected, compressor.compress(input));
    }
}
