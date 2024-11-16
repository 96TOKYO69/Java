import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Задача A2: Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        String[] numbers = new String[n];

        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }

        // Сортировка по возрастанию длины чисел
        Arrays.sort(numbers, Comparator.comparingInt(String::length));
        System.out.println("Числа, отсортированные по возрастанию длины: " + Arrays.toString(numbers));

        // Сортировка по убыванию длины чисел
        Arrays.sort(numbers, Comparator.comparingInt(String::length).reversed());
        System.out.println("Числа, отсортированные по убыванию длины: " + Arrays.toString(numbers));
    }
}
