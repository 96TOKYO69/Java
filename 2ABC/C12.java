import java.util.Random;
import java.util.Scanner;

/**
 * Задача C12: В матрице найти минимальный элемент и переместить его на место заданного элемента путем перестановки строк и столбцов.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C12 {
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
                matrix[i][j] = rand.nextInt(100) - 50;
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Получение позиции от пользователя
        int targetRow, targetCol;
        do {
            System.out.print("Введите позицию (строка столбец) (0-" + (n-1) + "): ");
            targetRow = scanner.nextInt();
            targetCol = scanner.nextInt();
        } while (targetRow < 0 || targetRow >= n || targetCol < 0 || targetCol >= n);

        // Поиск минимального элемента
        int minRow = 0, minCol = 0;
        int min = matrix[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        // Перестановка строк
        if (minRow != targetRow) {
            int[] temp = matrix[minRow];
            matrix[minRow] = matrix[targetRow];
            matrix[targetRow] = temp;
        }

        // Перестановка столбцов
        if (minCol != targetCol) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][minCol];
                matrix[i][minCol] = matrix[i][targetCol];
                matrix[i][targetCol] = temp;
            }
        }

        // Вывод обновленной матрицы
        System.out.println("Обновленная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
