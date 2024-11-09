import java.util.Scanner;
/**
 * Задача C5: Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C5 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        System.out.print("Введите число k: ");
        int k = scanner.nextInt();

        int[][] matrix = new int[n][n];
        int current = 1;

        // Заполняем матрицу числами от 1 до k слева направо и сверху вниз
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (current <= k) {
                    matrix[i][j] = current++;
                } else {
                    matrix[i][j] = 0; // Заполняем оставшиеся ячейки нулями
                }
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
