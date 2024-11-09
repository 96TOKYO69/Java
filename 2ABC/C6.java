import java.util.Random;
import java.util.Scanner;

/**
 * Задача C6: Округлить все элементы матрицы до целого числа.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C6 {
    public static void main(String[] args) {
        double[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new double[n][n];

        // Заполнение матрицы случайными вещественными числами в диапазоне от -50 до 50
        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextDouble() * 100 - 50;
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Округление каждого элемента матрицы
        System.out.println("Матрица после округления:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.round(matrix[i][j]);
                System.out.printf("%8.0f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}