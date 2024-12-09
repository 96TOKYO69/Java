package com.example.zadanie3;

import org.example.Zadanie3.StudentProcessor;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentProcessorTest {

    private final String testInputFileName = "students_test.txt";
    private final File testInputFile = new File(testInputFileName);

    @BeforeEach
    void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testInputFile))) {
            writer.write("Ivanov,8.5");
            writer.newLine();
            writer.write("Petrov,6.0");
            writer.newLine();
            writer.write("Sidorov,9.0");
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        if (testInputFile.exists()) {
            testInputFile.delete();
        }
    }

    @Test
    void testProcessStudents() throws IOException {

        StudentProcessor processor = new StudentProcessor();

        processor.processStudents(testInputFileName);

        assertTrue(testInputFile.exists(), "Тестовый файл должен существовать");

        List<String> outputLines = Files.readAllLines(testInputFile.toPath());

        assertTrue(outputLines.contains("Список студентов с баллом выше 7:"), "Файл должен содержать заголовок");
        assertTrue(outputLines.contains("IVANOV"), "Файл должен содержать 'IVANOV'");
        assertTrue(outputLines.contains("SIDOROV"), "Файл должен содержать 'SIDOROV'");
        assertFalse(outputLines.contains("PETROV"), "Файл не должен содержать 'PETROV'");
    }
}
