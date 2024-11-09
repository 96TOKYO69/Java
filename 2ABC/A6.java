import java.util.Scanner;
/**
 * Задача A6: Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A6 {
    public static void main(String[] args) {
        System.out.print("Введите количество чисел: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите " + n + " чисел");

        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.next();
        }

        String result = findAscendingDigitsNumber(numbers);
        if (result != null) {
            System.out.println("Первое число, цифры в котором идут в строгом порядке возрастания: " + result);
        } else {
            System.out.println("Чисел с цифрами в строгом порядке возрастания не найдено.");
        }
    }

    public static String findAscendingDigitsNumber(String[] numbers) {
        for (String number : numbers) {
            if (isDigitsInAscendingOrder(number)) {
                return number;
            }
        }
        return null; // Возвращает null, если ни одно из чисел не соответствует условию
    }

    public static boolean isDigitsInAscendingOrder(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) >= number.charAt(i + 1)) {
                return false;
            }
        }
        return true; // Все цифры идут в строгом порядке возрастания
    }
}
