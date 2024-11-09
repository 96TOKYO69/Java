import java.util.Scanner;
/**
 * Задача A8: Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A8 {
    public static void main(String[] args) {
        System.out.print("Введите количество чисел: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите " + n + " чисел");

        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.next();
        }

        String result = findSecondPalindrome(numbers);
        if (result != null) {
            System.out.println("Второе число-палиндром: " + result);
        } else {
            System.out.println("Не найдено второго числа-палиндрома.");
        }
    }

    public static String findSecondPalindrome(String[] numbers) {
        int palindromeCount = 0;

        for (String number : numbers) {
            if (isPalindrome(number)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    return number; // Возвращаем второе найденное число-палиндром
                }
            }
        }
        return null; // Возвращает null, если второго палиндрома не найдено
    }

    public static boolean isPalindrome(String number) {
        int length = number.length();
        for (int i = 0; i < length / 2; i++) {
            if (number.charAt(i) != number.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
