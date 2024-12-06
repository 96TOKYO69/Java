package com.example.zadanie1;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.zadanie1.Zadanie1;
import org.junit.jupiter.api.Test;

class Zadanie1Test1 {

    @Test
    void testInsertWordAfterMatchingSubstring() {
        Zadanie1 processor = new Zadanie1();

        // Тест 1: стандартный случай
        String text = "hello world wonderful world";
        String substring = "world";
        String wordToAdd = "added";
        String expected = "hello world added wonderful world added";
        assertEquals(expected, processor.insertWordAfterMatchingSubstring(text, substring, wordToAdd));

        // Тест 2: подстрока не найдена
        substring = "java";
        expected = "hello world wonderful world";
        assertEquals(expected, processor.insertWordAfterMatchingSubstring(text, substring, wordToAdd));

        // Тест 3: текст пустой
        text = "";
        expected = "";
        assertEquals(expected, processor.insertWordAfterMatchingSubstring(text, substring, wordToAdd));

        // Тест 4: только одно слово
        text = "world";
        substring = "world";
        expected = "world added";
        assertEquals(expected, processor.insertWordAfterMatchingSubstring(text, substring, wordToAdd));
    }

}
