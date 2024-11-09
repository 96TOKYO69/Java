import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Задача C19: Путем перестановки элементов квадратной вещественной матрицы добиться
 * того, чтобы ее максимальный элемент находился в левом верхнем углу, следующий по величине — в позиции (2, 2),
 * следующий по величине — в позиции (3, 3) и т.д., заполнив таким образом всю главную диагональ.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class C19 {
    public static void main(String[] args) {
        double[][] matrix;
        int n;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность матрицы n: ");
        n = scanner.nextInt();
        matrix = new double[n][n];

        // Заполнение матрицы случайными вещественными значениями
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextDouble() * 100 - 50; // случайные числа от -50 до 50
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // Создание списка всех элементов
        double[] elements = new double[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                elements[index++] = matrix[i][j];
            }
        }

        // Сортировка по убыванию
        Arrays.sort(elements);
        for (int i = 0; i < elements.length / 2; i++) {
            double temp = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = temp;
        }

        // Заполнение главной диагонали
        index = 0;
        for (int i = 0; i < n; i++) {
            matrix[i][i] = elements[index++];
        }

        // Заполнение оставшихся элементов
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    matrix[i][j] = elements[index++];
                }
            }
        }

        // Печать итоговой матрицы
        System.out.println("Итоговая матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
