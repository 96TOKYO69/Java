import java.util.Random;
import java.util.Scanner;

/**
 * Задача C11: Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C11 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0},
                {0, 0, 0, 0, 0},
                {7, 0, 0, 0, 0}
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

        boolean[] rowsToKeep = new boolean[n];
        boolean[] colsToKeep = new boolean[n];

        // Проверка строк
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    rowsToKeep[i] = true;
                    break;
                }
            }
        }

        // Проверка столбцов
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] != 0) {
                    colsToKeep[j] = true;
                    break;
                }
            }
        }

        int newRows = 0;
        int newCols = 0;
        for (boolean b : rowsToKeep) {
            if (b) newRows++;
        }
        for (boolean b : colsToKeep) {
            if (b) newCols++;
        }

        int[][] newMatrix = new int[newRows][newCols];
        int newRow = 0;

        for (int i = 0; i < n; i++) {
            if (rowsToKeep[i]) {
                int newCol = 0;
                for (int j = 0; j < n; j++) {
                    if (colsToKeep[j]) {
                        newMatrix[newRow][newCol++] = matrix[i][j];
                    }
                }
                newRow++;
            }
        }

        // Вывод уплотненной матрицы
        System.out.println("Уплотненная матрица:");
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                System.out.printf("%4d", newMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
