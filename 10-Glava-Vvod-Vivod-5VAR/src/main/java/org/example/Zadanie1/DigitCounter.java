package org.example.Zadanie1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitCounter {
    public static int findLongestDigitSequence(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        int maxLength = 0;

        while (matcher.find()) {
            int length = matcher.group().length();
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
