import java.util.Scanner;
/**
 * Задача A7: Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A7 {
    public static void main(String[] args) {
        System.out.print("Введите количество чисел: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите " + n + " чисел");

        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.next();
        }

        String result = findUniqueDigitsNumber(numbers);
        if (result != null) {
            System.out.println("Первое число, состоящее только из различных цифр: " + result);
        } else {
            System.out.println("Чисел, состоящих только из различных цифр, не найдено.");
        }
    }

    public static String findUniqueDigitsNumber(String[] numbers) {
        for (String number : numbers) {
            if (hasUniqueDigits(number)) {
                return number;
            }
        }
        return null; // Возвращает null, если нет чисел с уникальными цифрами
    }

    public static boolean hasUniqueDigits(String number) {
        boolean[] digitSeen = new boolean[10]; // массив для отслеживания встреченных цифр от 0 до 9

        for (char digit : number.toCharArray()) {
            int d = digit - '0';
            if (digitSeen[d]) {
                return false; // Цифра уже встречалась
            }
            digitSeen[d] = true; // Отмечаем цифру как встреченную
        }
        return true; // Все цифры уникальны
    }
}
