import java.util.Random;
import java.util.Scanner;

/**
 * Задача C7: Повернуть матрицу на 90, 180 или 270 градусов против часовой стрелки.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C7 {
    public static void main(String[] args) {
        int[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new int[n][n];

        // Заполнение матрицы случайными значениями
        System.out.println("Исходная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100) - 50;
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("Введите угол поворота (90, 180, 270): ");
        int angle = scanner.nextInt();
        int rotations = (angle % 360) / 90; // количество поворотов на 90 градусов

        for (int r = 0; r < rotations; r++) {
            matrix = rotate90(matrix);
        }

        // Вывод повёрнутой матрицы
        System.out.println("Повернутая матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    // Метод для поворота матрицы на 90 градусов против часовой стрелки
    public static int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - 1 - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }
}