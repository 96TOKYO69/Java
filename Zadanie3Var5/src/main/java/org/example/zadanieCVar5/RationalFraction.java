package org.example.zadanieCVar5;

public class RationalFraction {
    private int numerator;
    private int denominator;

    // Конструктор
    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Упрощение дроби
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Метод для нахождения НОД
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Метод для сложения дробей
    public RationalFraction add(RationalFraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalFraction(newNumerator, newDenominator);
    }

    // Метод для умножения дробей
    public RationalFraction multiply(RationalFraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalFraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}