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

        try (RandomAccessFile raf = new RandomAccessFile(inputFile, "rw")) {
            long writePosition = raf.length();
            raf.seek(0);

            String line;
            while ((line = raf.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String lastName = parts[0].trim();
                    double averageScore = Double.parseDouble(parts[1].trim());

                    if (averageScore > 7.0) {

                        long currentPosition = raf.getFilePointer();

                        raf.seek(writePosition);
                        String upperLastName = lastName.toUpperCase() + System.lineSeparator();
                        raf.writeBytes(upperLastName);

                        writePosition += upperLastName.getBytes().length;
                        raf.seek(currentPosition);
                    }
                }
            }
        }
    }
}
