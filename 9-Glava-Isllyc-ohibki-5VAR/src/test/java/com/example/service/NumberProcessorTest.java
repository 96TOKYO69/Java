package com.example.service;

import org.example.exceptions.CustomException;
import org.example.service.NumberProcessor;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class NumberProcessorTest {
    private NumberProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new NumberProcessor();
    }

    @Test
    public void testReadFile_ValidFile() throws CustomException {
        String filePath = "src/main/resources/valid_numbers.txt";
        processor.readFile(filePath);

        assertEquals(3, processor.getNumbers().size());
    }

    @Test
    public void testReadFile_FileNotFound() {
        String filePath = "nonexistent_file.txt";
        CustomException exception = assertThrows(CustomException.class, () -> processor.readFile(filePath));
        assertTrue(exception.getMessage().contains("Файл не найден"));
    }

    @Test
    public void testCalculateSumAndAverage() throws CustomException {
        String filePath = "src/main/resources/valid_numbers.txt";
        processor.readFile(filePath);

        assertEquals(1855.79, processor.calculateSum(), 0.01);
        assertEquals(618.6, processor.calculateAverage(), 0.01);
    }
}
