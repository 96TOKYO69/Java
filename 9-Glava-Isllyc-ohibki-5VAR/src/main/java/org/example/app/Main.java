package org.example.app;

import org.example.service.NumberProcessor;
import org.example.exceptions.CustomException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/valid_numbers.txt";
        NumberProcessor processor = new NumberProcessor();

        try {
            processor.readFile(filePath);
            System.out.println("Сумма чисел: " + processor.calculateSum());
            System.out.println("Среднее значение: " + processor.calculateAverage());
        } catch (CustomException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
