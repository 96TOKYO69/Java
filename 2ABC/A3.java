import java.util.Scanner;
/**
 * Задача A3: Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        String[] numbers = new String[n];
        int totalLength = 0;

        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
            totalLength += numbers[i].length();
        }

        // Вычисление средней длины
        double averageLength = (double) totalLength / n;
        System.out.println("Средняя длина чисел: " + averageLength);

        // Числа, длина которых меньше средней
        System.out.println("Числа, длина которых меньше средней:");
        for (String number : numbers) {
            if (number.length() < averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }

        // Числа, длина которых больше средней
        System.out.println("Числа, длина которых больше средней:");
        for (String number : numbers) {
            if (number.length() > averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }
    }
}
