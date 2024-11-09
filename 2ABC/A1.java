import java.util.Scanner;
/**
 * Задача A1: Найти самое короткое и самое длинное число.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        String[] numbers = new String[n];

        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }

        String minNum = numbers[0];
        String maxNum = numbers[0];

        for (String num : numbers) {
            if (num.length() < minNum.length()) {
                minNum = num;
            }
            if (num.length() > maxNum.length()) {
                maxNum = num;
            }
        }

        System.out.println("Самое короткое число: " + minNum + " (Длина: " + minNum.length() + ")");
        System.out.println("Самое длинное число: " + maxNum + " (Длина: " + maxNum.length() + ")");

        scanner.close();
    }
}
