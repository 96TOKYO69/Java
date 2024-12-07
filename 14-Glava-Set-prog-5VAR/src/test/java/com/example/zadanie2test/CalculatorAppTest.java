package com.example.zadanie2test;

import org.example.zadanie2.GoogleSheetsService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorAppTest {

    private GoogleSheetsService googleSheetsService = new GoogleSheetsService();

    CalculatorAppTest() throws GeneralSecurityException, IOException {
    }

    @Test
    void testCalculateAddition() throws GeneralSecurityException, IOException {
        double num1 = 10.0;
        double num2 = 5.0;
        String operator = "+";

        double result = googleSheetsService.calculateUsingGoogleSheets(num1, num2, operator);

        assertEquals(15.0, result, 0.0001, "Сложение выполнено неправильно");
    }

    @Test
    void testCalculateSubtraction() throws GeneralSecurityException, IOException {
        double num1 = 10.0;
        double num2 = 5.0;
        String operator = "-";

        double result = googleSheetsService.calculateUsingGoogleSheets(num1, num2, operator);

        assertEquals(5.0, result, 0.0001, "Вычитание выполнено неправильно");
    }

    @Test
    void testCalculateMultiplication() throws GeneralSecurityException, IOException {
        double num1 = 10.0;
        double num2 = 5.0;
        String operator = "*";

        double result = googleSheetsService.calculateUsingGoogleSheets(num1, num2, operator);

        assertEquals(50.0, result, 0.0001, "Умножение выполнено неправильно");
    }

    @Test
    void testCalculateDivision() throws GeneralSecurityException, IOException {
        double num1 = 10.0;
        double num2 = 2.0;
        String operator = "/";

        double result = googleSheetsService.calculateUsingGoogleSheets(num1, num2, operator);

        assertEquals(5.0, result, 0.0001, "Деление выполнено неправильно");
    }

    @Test
    void testCalculateDivisionByZero() throws GeneralSecurityException {
        double num1 = 10.0;
        double num2 = 0.0;
        String operator = "/";

        Exception exception = assertThrows(ArithmeticException.class, () ->
                googleSheetsService.calculateUsingGoogleSheets(num1, num2, operator));

        assertEquals("Ошибка: деление на ноль.", exception.getMessage());
    }
}
