import java.util.Random;
import java.util.Scanner;

/**
 * Задача C15: Перестроить матрицу, переставляя в ней строки так, чтобы сумма элементов в строках полученной матрицы возрастала
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C15 {
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

        int[] sums = new int[n]; // Массив для хранения сумм строк

        // Вычисление сумм строк
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sums[i] += matrix[i][j];
            }
        }

        // Сортировка строк на основе сумм
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sums[j] > sums[j + 1]) {
                    // Обмен сумм
                    int tempSum = sums[j];
                    sums[j] = sums[j + 1];
                    sums[j + 1] = tempSum;

                    // Обмен строк матрицы
                    int[] tempRow = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = tempRow;
                }
            }
        }

        // Вывод перестроенной матрицы и сумм
        System.out.println("Перестроенная матрица и суммы строк:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.printf("| Сумма: %d", sums[i]); // Вывод суммы строки
            System.out.println();
        }
    }
}
