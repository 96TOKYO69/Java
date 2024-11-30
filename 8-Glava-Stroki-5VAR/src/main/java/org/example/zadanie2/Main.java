package org.example.zadanie2;

import org.example.zadanie2.model.TextProcessor;

public class Main {
    public static void main(String[] args) {
        String text = """
                This is a test paragraph. It contains multiple sentences.

                Another paragraph is here. Testing continues.
                """;

        TextProcessor processor = new TextProcessor(text);
        System.out.println("Original Text:\n" + text);
        processor.processText();
        System.out.println("\nProcessed Text:\n" + processor);
    }
}

