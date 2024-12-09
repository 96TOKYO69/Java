package org.example.service;

import org.example.exceptions.CustomException;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class NumberProcessor {
    private final List<Number> numbers = new ArrayList<>();

    public void readFile(String filePath) throws CustomException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new CustomException("Файл не найден: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            throw new CustomException("Ошибка чтения файла", e);
        } catch (OutOfMemoryError e) {
            throw new CustomException("Недостаточно памяти для обработки файла", e);
        }
    }

    private void processLine(String line) throws CustomException {
        String[] parts = line.split(",");
        if (parts.length != 2) {
            throw new CustomException("Некорректная строка: " + line);
        }

        String localeString = parts[0].trim();
        String numberString = parts[1].trim();

        try {
            Locale locale = new Locale(localeString);
            NumberFormat format = NumberFormat.getInstance(locale);
            Number number = format.parse(numberString);

            if (number.doubleValue() > Double.MAX_VALUE || number.doubleValue() < -Double.MAX_VALUE) {
                throw new CustomException("Число выходит за допустимые пределы: " + number);
            }

            numbers.add(number);
        } catch (IllegalArgumentException | ParseException e) {
            throw new CustomException("Ошибка обработки строки: " + line, e);
        }
    }

    public double calculateSum() {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }

    public double calculateAverage() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return calculateSum() / numbers.size();
    }

    public List<Number> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
