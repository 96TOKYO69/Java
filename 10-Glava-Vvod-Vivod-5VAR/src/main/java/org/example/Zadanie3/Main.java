package org.example.Zadanie3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String resourceFileName = "students.txt";

        // Путь относительно корня проекта
        File outputDir = new File("output");

        StudentProcessor processor = new StudentProcessor();

        try {
            processor.processStudents(resourceFileName, outputDir);
            System.out.println("Рабочий каталог: " + new File(".").getAbsolutePath());
            System.out.println("Обработка завершена. Проверьте каталог \"output\" в корневом каталоге проекта.");
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}


