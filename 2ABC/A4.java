import java.util.Scanner;
/**
 * Задача A4: Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A4 {
    public static void main(String[] args) {
        System.out.print("Введите количество чисел: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите " + n + " чисел");
        String[] numbers = new String[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.next();
        }

        String minNumber = findMinUniqueDigits(numbers);
        System.out.println("Число с минимальным количеством различных цифр: " + minNumber);
    }

    private static String findMinUniqueDigits(String[] numbers) {
        String minNumber = null;
        int minUniqueCount = Integer.MAX_VALUE;

        for (String number : numbers) {
            int uniqueCount = countUniqueDigits(number);
            if (uniqueCount < minUniqueCount) {
                minUniqueCount = uniqueCount;
                minNumber = number;
            }
        }

        return minNumber;
    }

    private static int countUniqueDigits(String number) {
        boolean[] digits = new boolean[10]; // Массив для отслеживания цифр
        int count = 0;

        for (char digit : number.toCharArray()) {
            int d = digit - '0'; // Преобразуем символ в цифру
            if (!digits[d]) {
                digits[d] = true; // Отмечаем цифру как встреченную
                count++;
            }
        }

        return count;
    }
}
