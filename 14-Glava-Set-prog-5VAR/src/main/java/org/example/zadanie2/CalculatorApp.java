package org.example.zadanie2;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double num1 = getNumberInput(scanner, "Введите первое число:");

            String operator = getOperatorInput(scanner, "Введите операцию (+, -, *, /):");

            double num2 = getNumberInput(scanner, "Введите второе число:");

            GoogleSheetsService googleSheetsService = new GoogleSheetsService();
            double result = googleSheetsService.calculateUsingGoogleSheets(num1, num2, operator);

            System.out.println("Результат: " + result);
        } catch (IOException | GeneralSecurityException e) {
            System.err.println("Ошибка подключения к Google Sheets: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static double getNumberInput(Scanner scanner, String prompt) {
        double number;
        while (true) {
            System.out.println(prompt);
            try {
                number = scanner.nextDouble();
                return number;
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введите корректное число.");
                scanner.next();
            }
        }
    }

    private static String getOperatorInput(Scanner scanner, String prompt) {
        String operator;
        while (true) {
            System.out.println(prompt);
            operator = scanner.next();
            if (operator.matches("[+\\-*/]")) {
                return operator;
            } else {
                System.err.println("Ошибка: введите корректную операцию (+, -, *, /).");
            }
        }
    }
}
