package org.example.Zadanie3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class StudentProcessor {

    public void processStudents(String filePath) throws IOException {
        File inputFile = new File(filePath);

        if (!inputFile.exists()) {
            throw new IOException("Файл не найден: " + filePath);
        }

        File tempFile = new File(filePath + ".tmp");

        try (RandomAccessFile inputRaf = new RandomAccessFile(inputFile, "r");
             RandomAccessFile outputRaf = new RandomAccessFile(tempFile, "rw")) {

            String line;
            while ((line = inputRaf.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String lastName = parts[0].trim();
                    double averageScore = Double.parseDouble(parts[1].trim());

                    if (averageScore > 7.0) {
                        lastName = lastName.toUpperCase();
                    }

                    outputRaf.writeBytes(lastName + "," + averageScore + System.lineSeparator());
                }
            }
        }

        if (!inputFile.delete()) {
            throw new IOException("Не удалось удалить исходный файл");
        }
        if (!tempFile.renameTo(inputFile)) {
            throw new IOException("Не удалось переименовать временный файл");
        }
    }
}
