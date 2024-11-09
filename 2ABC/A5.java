import java.util.Scanner;
/**
 * Задача A5: Найти количество чисел, содержащих только четные цифры, а среди них — количество чисел с равным числом четных и нечетных цифр.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A5 {
    public static void main(String[] args) {
        System.out.print("Введите количество чисел: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите " + n + " чисел");

        int countEvenDigitNumbers = 0;
        int countEqualEvenOdd = 0;

        for (int i = 0; i < n; i++) {
            String number = sc.next();

            // Проверка на наличие только четных цифр
            if (containsOnlyEvenDigits(number)) {
                countEvenDigitNumbers++;
            }

            // Проверка на равное количество четных и нечетных цифр
            if (hasEqualEvenAndOddDigits(number)) {
                countEqualEvenOdd++;
            }
        }

        System.out.println("Количество чисел, содержащих только четные цифры: " + countEvenDigitNumbers);
        System.out.println("Количество чисел с равным числом четных и нечетных цифр: " + countEqualEvenOdd);
    }

    public static boolean containsOnlyEvenDigits(String number) {
        for (char digit : number.toCharArray()) {
            if ((digit - '0') % 2 != 0) { // Проверяем, является ли цифра нечетной
                return false;
            }
        }
        return true; // Все цифры четные
    }

    public static boolean hasEqualEvenAndOddDigits(String number) {
        int evenCount = 0;
        int oddCount = 0;

        for (char digit : number.toCharArray()) {
            if ((digit - '0') % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return evenCount == oddCount; // Проверяем, равны ли четные и нечетные цифры
    }
}
