package org.example.zadanie3Var5;

public class Main {
    public static void main(String[] args) {
        int n = 3; // размерность массива
        Complex[] complexArray = new Complex[n];

        // Инициализация массива
        complexArray[0] = new Complex(new RationalFraction(1, 2), new RationalFraction(1, 3));
        complexArray[1] = new Complex(new RationalFraction(3, 4), new RationalFraction(2, 5));
        complexArray[2] = new Complex(new RationalFraction(5, 6), new RationalFraction(7, 8));

        // Сложение всех элементов массива
        Complex sum = complexArray[0];
        for (int i = 1; i < n; i++) {
            sum = sum.add(complexArray[i]);
        }
        System.out.println("Сумма всех элементов массива: " + sum);

        // Умножение всех элементов массива
        Complex product = complexArray[0];
        for (int i = 1; i < n; i++) {
            product = product.multiply(complexArray[i]);
        }
        System.out.println("Произведение всех элементов массива: " + product);
    }
}