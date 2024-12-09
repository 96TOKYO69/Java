package com.example.zadanie1;

import org.example.Zadanie1.DigitCounter;
import org.example.Zadanie1.FilePaths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringProcessorTest {
    private final Path testInputFile = Path.of("test_input.txt");
    private final Path testOutputFile = Path.of("test_output.txt");
    private final Path pathsFile = Path.of("paths.txt");

    @BeforeEach
    void setUp() throws IOException {
        Files.writeString(testInputFile, "abc123456def78gh\n90");
        Files.writeString(pathsFile, testInputFile.toAbsolutePath() + "\n" + testOutputFile.toAbsolutePath());
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(testInputFile);
        Files.deleteIfExists(testOutputFile);
        Files.deleteIfExists(pathsFile);
    }

    @Test
    void testFindLongestDigitSequence() {
        String input = "abc123456def78gh\n90";
        int result = DigitCounter.findLongestDigitSequence(input);
        assertEquals(6, result, "Длина самой длинной последовательности должна быть 6.");
    }

    @Test
    void testFilePaths() throws IOException {
        FilePaths filePaths = new FilePaths(pathsFile.toString());
        assertEquals(testInputFile.toAbsolutePath().toString(), filePaths.getInputFilePath());
        assertEquals(testOutputFile.toAbsolutePath().toString(), filePaths.getOutputFilePath());
    }

    @Test
    void testFilePathsInvalidFile() throws IOException {
        Path invalidPathsFile = Path.of("invalid_paths.txt");
        Files.writeString(invalidPathsFile, "only_one_path\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new FilePaths(invalidPathsFile.toString()));
        assertEquals("Пути к файлам файл должен содержать не менее двух строк.", exception.getMessage());
        Files.deleteIfExists(invalidPathsFile);
    }

    @Test
    void testMainLogic() throws IOException {
        FilePaths filePaths = new FilePaths(pathsFile.toString());

        List<String> lines = Files.readAllLines(Path.of(filePaths.getInputFilePath()));

        int maxSequence = lines.stream()
                .mapToInt(DigitCounter::findLongestDigitSequence)
                .max()
                .orElse(0);

        Files.writeString(Path.of(filePaths.getOutputFilePath()), String.valueOf(maxSequence));

        String output = Files.readString(testOutputFile);
        assertEquals("6", output, "Максимальная длина последовательности должна быть записана в выходной файл.");
    }
}
