package org.example.Zadanie1.app;

import org.example.Zadanie1.processor.StringProcessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();

        try {
            int maxLength = processor.processFileFromResources("input.txt");
            System.out.println("Наибольшее количество цифр, следующих подряд: " + maxLength);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
