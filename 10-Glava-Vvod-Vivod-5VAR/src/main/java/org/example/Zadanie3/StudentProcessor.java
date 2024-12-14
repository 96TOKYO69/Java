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
            String line;
            long filePointer;
            
            while ((filePointer = raf.getFilePointer()) < raf.length() && (line = raf.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String lastName = parts[0].trim();
                    double averageScore = Double.parseDouble(parts[1].trim());

                    if (averageScore > 7.0) {
                        lastName = lastName.toUpperCase();
                    }
                    
                    raf.seek(filePointer);
                    
                    raf.writeBytes(lastName + "," + parts[1] + System.lineSeparator());
                }
            }
        }
    }
}
