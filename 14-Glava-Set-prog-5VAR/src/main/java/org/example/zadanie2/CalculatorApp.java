package org.example.zadanie2;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double num1 = scanner.nextDouble();

        System.out.println("Введите операцию (+, -, *, /):");
        String operator = scanner.next();

        System.out.println("Введите второе число:");
        double num2 = scanner.nextDouble();

        Calculator calculator = new Calculator();
        double result = calculator.calculate(num1, num2, operator);

        System.out.println("Результат: " + result);

        GoogleSheetsService googleSheetsService = new GoogleSheetsService();
        googleSheetsService.saveResultToGoogleSheets(result);

        scanner.close();
    }
}
