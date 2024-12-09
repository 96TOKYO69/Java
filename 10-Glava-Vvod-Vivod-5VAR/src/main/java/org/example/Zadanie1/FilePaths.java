package org.example.Zadanie1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilePaths {
    private final String inputFilePath;
    private final String outputFilePath;

    public FilePaths(String pathsFilePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(pathsFilePath));
        if (lines.size() < 2) {
            throw new IllegalArgumentException("Пути к файлам файл должен содержать не менее двух строк.");
        }
        this.inputFilePath = lines.get(0).trim();
        this.outputFilePath = lines.get(1).trim();
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }
}
