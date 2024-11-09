import java.util.Random;
import java.util.Scanner;

/**
 * Задача C18: Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы значения
 * их характеристик убывали. Характеристикой столбца прямоугольной
 * матрицы называется сумма модулей его элементов.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C18 {
    public static void main(String[] args) {
        int[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new int[n][n];

        // Заполнение матрицы случайными целыми значениями
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100) - 50; // значения от -50 до 49
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        double[] characteristics = new double[n];

        // Вычисление характеристик столбцов
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                characteristics[j] += Math.abs(matrix[i][j]);
            }
        }

        // Вывод характеристик столбцов
        System.out.println("Характеристики столбцов:");
        for (int j = 0; j < n; j++) {
            System.out.printf("Столбец %d: %.2f%n", j + 1, characteristics[j]);
        }
        System.out.println();

        // Сортировка столбцов по убыванию характеристик
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (characteristics[j] < characteristics[j + 1]) {
                    // Обмен характеристик
                    double tempChar = characteristics[j];
                    characteristics[j] = characteristics[j + 1];
                    characteristics[j + 1] = tempChar;

                    // Обмен столбцов
                    for (int k = 0; k < n; k++) {
                        int temp = matrix[k][j];
                        matrix[k][j] = matrix[k][j + 1];
                        matrix[k][j + 1] = temp;
                    }
                }
            }
        }

        // Вывод отсортированной матрицы
        System.out.println("Отсортированная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
