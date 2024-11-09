import java.util.Random;
import java.util.Scanner;

/**
 * Задача C14: Найти количество всех седловых точек матрицы (матрица А имеет седловую точку А[i, j],
 * если А[i, j] является минимальным элементом в i-й строке и максимальным в j-м столбце).
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C14 {
    public static void main(String[] args) {
        int[][] matrix = {
                {4, 2, 3, 4, 5},
                {1, 6, 6, 6, 8},
                {9, 8, 0, 10, 11},
                {12, 16, 11, 13, 14},
                {9, 15, 10, 17, 0}
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
        int count = 0;

        // Поиск седловых точек
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Проверка, является ли элемент минимальным в строке
                boolean isMinInRow = true;
                for (int k = 0; k < n; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        isMinInRow = false;
                        break;
                    }
                }

                // Проверка, является ли элемент максимальным в столбце
                boolean isMaxInCol = true;
                for (int k = 0; k < n; k++) {
                    if (matrix[k][j] > matrix[i][j]) {
                        isMaxInCol = false;
                        break;
                    }
                }

                // Если элемент является седловой точкой, увеличиваем счетчик
                if (isMinInRow && isMaxInCol) {
                    count++;
                    System.out.printf("Седловая точка найдена в позиции [%d,%d] = %d%n", i, j, matrix[i][j]);
                }
            }
        }
        // Вывод общего количества седловых точек
        System.out.println("Всего найдено седловых точек: " + count);
    }
}
