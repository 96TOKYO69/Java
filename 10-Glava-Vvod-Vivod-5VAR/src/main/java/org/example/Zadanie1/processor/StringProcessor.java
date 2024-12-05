package org.example.Zadanie1.processor;

import java.io.*;
import java.util.regex.*;

public class StringProcessor {

    /**
     * Найти в строке наибольшее количество цифр, следующих подряд.
     *
     * @param input строка для анализа
     * @return длина самой длинной последовательности цифр
     */
    public int findLongestDigitSequence(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        int maxLength = 0;

        while (matcher.find()) {
            int length = matcher.group().length();
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    /**
     * Обработать текстовый файл из ресурсов и найти максимальную последовательность цифр.
     *
     * @param resourceFileName имя файла в ресурсах
     * @return длина самой длинной последовательности цифр во всем файле
     * @throws IOException при ошибках чтения файла
     */
    public int processFileFromResources(String resourceFileName) throws IOException {
        InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resourceFileName);
        if (resourceStream == null) {
            throw new FileNotFoundException("Файл не найден в ресурсах: " + resourceFileName);
        }

        int maxLength = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int length = findLongestDigitSequence(line);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }
}
