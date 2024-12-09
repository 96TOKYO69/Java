package org.example.Zadanie1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            FilePaths filePaths = new FilePaths("src/main/resources/paths.txt");

            List<String> lines = Files.readAllLines(Path.of(filePaths.getInputFilePath()));

            int maxSequence = lines.stream()
                    .mapToInt(DigitCounter::findLongestDigitSequence)
                    .max()
                    .orElse(0);

            Files.writeString(Path.of(filePaths.getOutputFilePath()), String.valueOf(maxSequence));

            System.out.println("Максимальная последовательность сохраненна в файл: " + filePaths.getOutputFilePath());
        } catch (IOException e) {
            System.err.println("Файлы с ошибками при обработке: " + e.getMessage());
        }
    }
}
