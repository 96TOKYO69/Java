package org.example.zadanie1;


import java.util.Scanner;

public class Zadanie1{

    /**
     * Вставляет указанное слово после каждого слова текста, заканчивающегося заданной подстрокой.
     *
     * @param text       исходный текст
     * @param substring  подстрока, по которой ищутся слова
     * @param wordToAdd  слово, которое нужно вставить
     * @return           текст с добавленным словом
     */
    public String insertWordAfterMatchingSubstring(String text, String substring, String wordToAdd) {

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(word);
            if (word.endsWith(substring)) {
                result.append(" ").append(wordToAdd);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zadanie1 processor = new Zadanie1();

        // Ввод данных
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите подстроку, по которой ищутся слова:");
        String substring = scanner.nextLine();

        System.out.println("Введите слово, которое нужно вставить:");
        String wordToAdd = scanner.nextLine();

        // Обработка текста
        try {
            String result = processor.insertWordAfterMatchingSubstring(text, substring, wordToAdd);
            System.out.println("Результат обработки текста:");
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
