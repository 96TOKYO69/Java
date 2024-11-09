import java.util.Random;
import java.util.Scanner;

/**
 * Задача C16: Найти число локальных минимумов. Соседями элемента матрицы назовем
 * элементы, имеющие с ним общую сторону или угол. Элемент матрицы называется
 * локальным минимумом, если он строго меньше всех своих соседей.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C16 {
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
                matrix[i][j] = rand.nextInt(100) - 50; // значения от -50 до 49
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        int count = 0; // Счетчик локальных минимумов
        // Массивы для смещения по координатам соседей
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Поиск локальных минимумов
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isLocalMin = true; // Флаг, указывающий, является ли элемент локальным минимумом

                // Проверка соседей
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k]; // Новая строка
                    int nj = j + dy[k]; // Новый столбец

                    // Проверка границ матрицы
                    if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                        if (matrix[ni][nj] <= matrix[i][j]) { // Если сосед не больше текущего
                            isLocalMin = false; // Устанавливаем флаг в false
                            break; // Выход из цикла
                        }
                    }
                }

                // Если элемент является локальным минимумом, увеличиваем счетчик
                if (isLocalMin) {
                    count++;
                    System.out.printf("Локальный минимум в позиции [%d,%d] = %d%n", i, j, matrix[i][j]);
                }
            }
        }
        System.out.println("Всего локальных минимумов: " + count);
    }
}
