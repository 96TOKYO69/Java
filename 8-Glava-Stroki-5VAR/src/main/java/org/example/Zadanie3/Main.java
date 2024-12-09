package org.example.Zadanie3;


public class Main {
    public static void main(String[] args) {
        TextCompressor compressor = new TextCompressor();

        String text = "hellowoooorld";
        String compressed = compressor.compress(text);

        System.out.println("Original text: " + text);
        System.out.println("Compressed text: " + compressed);
    }
}
