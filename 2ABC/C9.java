import java.util.Random;
import java.util.Scanner;

/**
 * Задача C9: Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C9 {
    public static void main(String[] args) {
        double[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new double[n][n];

        // Заполнение матрицы случайными значениями и вывод
        System.out.println("Исходная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100) - 50;
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Вычитание среднего арифметического из элементов каждой строки
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
            double avg = sum / n;

            for (int j = 0; j < n; j++) {
                matrix[i][j] -= avg;
            }
        }

        // Вывод измененной матрицы
        System.out.println("Измененная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
