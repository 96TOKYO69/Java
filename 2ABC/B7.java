/**
 * Задача B7: Написать код программы, которая бы переводила числа из десятичной системы счисления в любую другую.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
import java.util.Scanner;
public class B7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите десятичное число: ");
        int decimalNumber = scanner.nextInt();

        System.out.print("Введите основание системы счисления (2-36): ");
        int base = scanner.nextInt();

        if (base < 2 || base > 36) {
            System.out.println("Недопустимое основание системы счисления. Пожалуйста, введите значение от 2 до 36.");
        } else {
            String result = "";
            int temp = decimalNumber;

            while (temp > 0) {
                int remainder = temp % base;

                // Определяем символ для цифры в основании
                if (remainder < 10) {
                    result = remainder + result;
                } else {
                    result = (char) ('A' + remainder - 10) + result;
                }

                temp = temp / base;
            }

            System.out.println("Результат: " + result);
        }

        scanner.close();
    }
}
