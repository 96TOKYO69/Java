import java.util.Random;
import java.util.Scanner;

/**
 * Задача C10: Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C10 {
    public static void main(String[] args) {
        int[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new int[n][n];

        // Заполнение матрицы случайными значениями и вывод
        System.out.println("Исходная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100) - 50;
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Поиск максимального элемента
        int max = matrix[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        // Создание массивов для отметки строк и столбцов к удалению
        boolean[] rowsToRemove = new boolean[n];
        boolean[] colsToRemove = new boolean[n];

        // Отметка строк и столбцов с максимальным элементом
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == max) {
                    rowsToRemove[i] = true;
                    colsToRemove[j] = true;
                }
            }
        }

        // Подсчет новых размеров матрицы
        int newRows = 0;
        int newCols = 0;
        for (boolean b : rowsToRemove) {
            if (!b) newRows++;
        }
        for (boolean b : colsToRemove) {
            if (!b) newCols++;
        }

        // Создание новой матрицы без строк и столбцов с максимальным элементом
        int[][] newMatrix = new int[newRows][newCols];
        int newRow = 0;
        for (int i = 0; i < n; i++) {
            if (!rowsToRemove[i]) {
                int newCol = 0;
                for (int j = 0; j < n; j++) {
                    if (!colsToRemove[j]) {
                        newMatrix[newRow][newCol++] = matrix[i][j];
                    }
                }
                newRow++;
            }
        }

        // Вывод новой матрицы
        System.out.println("Матрица после удаления строк и столбцов с максимальным элементом:");
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                System.out.printf("%8d ", newMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
