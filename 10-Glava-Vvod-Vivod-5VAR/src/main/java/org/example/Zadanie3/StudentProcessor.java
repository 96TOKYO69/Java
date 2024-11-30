package org.example.Zadanie3;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentProcessor {

    public void processStudents(String resourceFileName, File outputDir) throws IOException {
        // Создаем папку "output" в корне проекта, если она не существует
        if (!outputDir.exists() && !outputDir.mkdir()) {
            throw new IOException("Failed to create output directory: " + outputDir.getAbsolutePath());
        }

        // Указываем файл в папке "output"
        File outputFile = new File(outputDir, "ProcessedStudents.txt");

        // Читаем студентов из ресурса
        List<Student> students = readStudentsFromResource(resourceFileName);

        // Записываем результаты
        writeProcessedStudentsToFile(outputFile, students);
    }

    private List<Student> readStudentsFromResource(String resourceFileName) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(resourceFileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String lastName = parts[0].trim();
                    double averageScore = Double.parseDouble(parts[1].trim());
                    students.add(new Student(lastName, averageScore));
                }
            }
        }
        return students;
    }

    private void writeProcessedStudentsToFile(File outputFile, List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Student student : students) {
                if (student.getAverageScore() > 7.0) {
                    writer.write(student.getLastName().toUpperCase());
                    writer.newLine();
                }
            }
        }
    }
}

