package org.example.zadanie2;

import org.example.zadanie2.model.TextProcessor;

public class Main {
    public static void main(String[] args) {
        String text = """
        Это тестовый абзац. Он содержит несколько предложений.
        
        Вот ещё один абзац. Тестирование продолжается.
        """;

        TextProcessor processor = new TextProcessor(text);
        System.out.println("Оригинальный текст:\n" + text);
        System.out.println("Длина оригинального текста: " + text.length() + " символов");

        processor.processText();
        String processedText = processor.toString();
        System.out.println("\nОбработанный текст:\n" + processedText);
        System.out.println("Длина обработанного текста: " + processedText.length() + " символов");

        if (text.length() != processedText.length()) {
            System.out.println("Ошибка: длины не совпадают!");
            System.out.println("Разница в длине: " + (text.length() - processedText.length()) + " символов");

            System.out.println("\nОригинал символы:");
            for (int i = 0; i < text.length(); i++) {
                System.out.println("Символ " + i + ": '" + text.charAt(i) + "'");
            }

            System.out.println("\nОбработанный символы:");
            for (int i = 0; i < processedText.length(); i++) {
                System.out.println("Символ " + i + ": '" + processedText.charAt(i) + "'");
            }
        } else {
            System.out.println("Длины совпадают!");
        }
    }


}
