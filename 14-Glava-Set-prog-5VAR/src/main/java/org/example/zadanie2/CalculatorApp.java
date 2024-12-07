package org.example.zadanie2;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите первое число:");
            double num1 = scanner.nextDouble();

            System.out.println("Введите операцию (+, -, *, /):");
            String operator = scanner.next();

            System.out.println("Введите второе число:");
            double num2 = scanner.nextDouble();

            GoogleSheetsService googleSheetsService = new GoogleSheetsService();
            double result = googleSheetsService.calculateUsingGoogleSheets(num1, num2, operator);

            System.out.println("Результат: " + result);
        } catch (IOException | GeneralSecurityException e) {
            System.err.println("Ошибка подключения к Google Sheets: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
