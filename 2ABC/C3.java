import java.util.Random;
import java.util.Scanner;

/**
 * Задача C3: Найти и вывести наибольшее число возрастающих / убывающих элементов матрицы, идущих подряд.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C3 {
    public static void main(String[] args) {
        int[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new int[n][n];

        // Fill the matrix with random integer values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100) - 50;
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        int maxIncreasingLength = 1;
        int maxDecreasingLength = 1;

        // Check for longest increasing and decreasing sequences
        for (int i = 0; i < n; i++) {
            int currentIncreasingLength = 1;
            int currentDecreasingLength = 1;

            for (int j = 1; j < n; j++) {
                // Check for increasing sequence
                if (matrix[i][j] > matrix[i][j - 1]) {
                    currentIncreasingLength++;
                    maxIncreasingLength = Math.max(maxIncreasingLength, currentIncreasingLength);
                } else {
                    currentIncreasingLength = 1; // Reset for increasing
                }

                // Check for decreasing sequence
                if (matrix[i][j] < matrix[i][j - 1]) {
                    currentDecreasingLength++;
                    maxDecreasingLength = Math.max(maxDecreasingLength, currentDecreasingLength);
                } else {
                    currentDecreasingLength = 1; // Reset for decreasing
                }
            }
        }

        // Output the results
        System.out.println("Наибольшее число возрастающих элементов: " + maxIncreasingLength);
        System.out.println("Наибольшее число убывающих элементов: " + maxDecreasingLength);
    }
}