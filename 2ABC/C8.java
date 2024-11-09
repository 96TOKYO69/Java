import java.util.Random;
import java.util.Scanner;

/**
 * Задача C8: Вычислить определитель матрицы 3x3.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C8 {
    public static void main(String[] args) {
        int[][] matrix;
        int n = 3;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100) - 50;
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Вычисление определителя матрицы 3x3
        double det = calculateDeterminant3x3(matrix);
        System.out.printf("Определитель матрицы: %.2f%n", det);
    }

    // Метод для вычисления определителя матрицы 3x3
    public static double calculateDeterminant3x3(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }
}
