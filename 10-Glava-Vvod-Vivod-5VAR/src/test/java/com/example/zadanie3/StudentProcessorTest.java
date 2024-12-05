package com.example.zadanie3;
import org.example.Zadanie3.StudentProcessor;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentProcessorTest {

    private final File testOutputDir = new File("test_output");

    @AfterEach
    void tearDown() throws IOException {
        if (testOutputDir.exists()) {
            for (File file : testOutputDir.listFiles()) {
                file.delete();
            }
            testOutputDir.delete();
        }
    }

    @Test
    void testProcessStudents() throws IOException {
        StudentProcessor processor = new StudentProcessor();
        processor.processStudents("students.txt", testOutputDir);

        File outputFile = new File(testOutputDir, "ProcessedStudents.txt");
        assertTrue(outputFile.exists(), "Output file should exist");

        List<String> outputLines = Files.readAllLines(outputFile.toPath());
        assertEquals(2, outputLines.size());
        assertTrue(outputLines.contains("IVANOV"));
        assertTrue(outputLines.contains("SIDOROV"));
    }
}

