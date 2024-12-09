package org.example.Zadanie3;

import java.io.*;
import java.util.*;

public class StudentProcessor {

    public void processStudents(String filePath) throws IOException {

        File inputFile = new File(filePath);

        if (!inputFile.exists()) {
            throw new FileNotFoundException("Файл не найден: " + filePath);
        }

        List<Student> students = readStudentsFromFile(inputFile);

        writeProcessedStudentsToFile(inputFile, students);
    }

    private List<Student> readStudentsFromFile(File inputFile) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
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

    private void writeProcessedStudentsToFile(File file, List<Student> students) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine();
            writer.write("Список студентов с баллом выше 7:"); // Заголовок
            writer.newLine();

            for (Student student : students) {
                if (student.getAverageScore() > 7.0) {
                    writer.write(student.getLastName().toUpperCase());
                    writer.newLine();
                }
            }
        }
    }
}
