import java.util.Random;
import java.util.Scanner;

/**
 * Задача C17:  Найти наименьший среди локальных максимумов. Элемент матрицы называется локальным минимумом, если он строго меньше всех своих соседей.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C17 {
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

        int minLocalMax = Integer.MAX_VALUE; // Исправлено с int.POSITIVE_INFINITY на Integer.MAX_VALUE
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isLocalMax = true;

                // Проверка всех соседей
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                        if (matrix[ni][nj] >= matrix[i][j]) {
                            isLocalMax = false;
                            break;
                        }
                    }
                }

                // Если элемент является локальным максимумом
                if (isLocalMax && matrix[i][j] < minLocalMax) {
                    minLocalMax = matrix[i][j];
                }
            }
        }

        // Вывод результата
        if (minLocalMax != Integer.MAX_VALUE) { // Исправлено на Integer.MAX_VALUE
            System.out.printf("Наименьший локальный максимум: %d%n", minLocalMax); // Изменено на %d вместо %.2f
        } else {
            System.out.println("Локальные максимумы не найдены");
        }

        scanner.close(); // Закрываем сканер
    }
}
