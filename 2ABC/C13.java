import java.util.Random;
import java.util.Scanner;

/**
 * Задача C13: Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C13 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 0, 4, 5},
                {3, 0, 6, 0, 8},
                {9, 0, 0, 10, 11},
                {12, 13, 0, 0, 14},
                {0, 15, 16, 17, 0}
        };
        int n = matrix.length;

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
        System.out.println();

        // Преобразование строк матрицы
        for (int i = 0; i < n; i++) {
            int nonZeroPos = 0; // позиция для ненулевого элемента
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    if (j != nonZeroPos) {
                        // Перемещение ненулевого элемента на позицию nonZeroPos
                        matrix[i][nonZeroPos] = matrix[i][j];
                        matrix[i][j] = 0; // Установка текущей позиции в 0
                    }
                    nonZeroPos++;
                }
            }
        }

        // Вывод преобразованной матрицы
        System.out.println("Преобразованная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
