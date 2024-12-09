package com.example.zadanie3;

import org.example.Zadanie3.StudentProcessor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class StudentProcessorTest {

    private Path tempFile;
    private final StudentProcessor processor = new StudentProcessor();

    @BeforeEach
    void setUp() throws IOException {

        tempFile = Files.createTempFile("studentstest", ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Ivanov, 8.0");
            writer.newLine();
            writer.write("Petrov, 6.5");
            writer.newLine();
            writer.write("Sidorov, 7.5");
            writer.newLine();
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    void processStudents_ShouldAddUppercaseNames_WhenScoreAboveSeven() throws IOException {

        processor.processStudents(tempFile.toString());

        StringBuilder resultContent = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(tempFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultContent.append(line).append(System.lineSeparator());
            }
        }

        String expectedContent = """
                Ivanov, 8.0
                Petrov, 6.5
                Sidorov, 7.5
                IVANOV
                SIDOROV
                """;

        assertEquals(
                expectedContent.trim().replace("\n", System.lineSeparator()),
                resultContent.toString().trim().replace("\r\n", System.lineSeparator())
        );
    }
}
