import java.util.Random;
import java.util.Scanner;
/**
 * Задача C2: Выполнить циклический сдвиг заданной матрицы на k позиций (вправо,влево, вверх, вниз).
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C2 {
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

        System.out.print("Введите количество позиций для сдвига: ");
        int k = scanner.nextInt();
        System.out.println("Выберите направление (1-вправо, 2-влево, 3-вверх, 4-вниз): ");
        int direction = scanner.nextInt();

        k = k % n;
        int[][] temp = new int[n][n];

        switch (direction) {
            case 1: // вправо
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        temp[i][(j + k) % n] = matrix[i][j];
                    }
                }
                break;
            case 2: // влево
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        temp[i][j] = matrix[i][(j - k + n) % n]; // Adjust for left shift
                    }
                }
                break;
            case 3: // вверх
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        temp[(i - k + n) % n][j] = matrix[i][j]; // Adjust for upward shift
                    }
                }
                break;
            case 4: // вниз
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        temp[(i + k) % n][j] = matrix[i][j];
                    }
                }
                break;
            default:
                System.out.println("Неверное направление. Пожалуйста, выберите 1, 2, 3 или 4.");
                return;
        }

        matrix = temp;

        System.out.println("Сдвинутая матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}