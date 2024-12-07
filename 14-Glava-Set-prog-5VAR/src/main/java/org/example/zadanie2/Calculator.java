package org.example.zadanie2;

public class Calculator {

    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль");
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                System.out.println("Ошибка: неизвестная операция");
                return Double.NaN;
        }
    }
}
