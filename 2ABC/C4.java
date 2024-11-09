import java.util.Scanner;
/**
 * Задача C4: Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, -2, -3, 4},
                {4, -5, -6, 8},
                {7, -8, -9, 12}
        };
        int rows = matrix.length; // количество строк
        int cols = matrix[0].length; // количество столбцов
        Scanner scanner = new Scanner(System.in);

        // Вывод фиксированной матрицы
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Вычисляем сумму элементов между первым и вторым положительными элементами
        for (int i = 0; i < rows; i++) {
            int firstPos = -1;
            int secondPos = -1;
            int sum = 0;

            // Поиск позиций положительных элементов
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > 0) {
                    if (firstPos == -1) {
                        firstPos = j; // Первый положительный элемент
                    } else {
                        secondPos = j; // Второй положительный элемент
                        break;
                    }
                }
            }

            // Подсчет суммы между первым и вторым положительными элементами
            if (firstPos != -1 && secondPos != -1) {
                for (int j = firstPos + 1; j < secondPos; j++) {
                    sum += matrix[i][j];
                }
                System.out.printf("Строка %d: сумма = %d%n", i, sum);
            } else {
                System.out.printf("Строка %d: недостаточно положительных элементов для подсчета суммы.%n", i);
            }
        }
    }
}
