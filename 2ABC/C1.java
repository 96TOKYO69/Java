import java.util.Random;
import java.util.Scanner;
/**
 * Задача C1:Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C1 {
    public static void main(String[] args) {
        int[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100) - 50;
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.print("Введите номер столбца k: ");
        int k = scanner.nextInt();


        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (matrix[j][k] > matrix[j + 1][k]) {
                    int[] temp = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = temp;
                }
            }
        }

        System.out.println("Отсортированная матрица по столбцу " + k + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}