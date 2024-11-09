import java.util.Scanner;

public class Zadanie15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n\n«Счастливые» числа:");
        for (int number : numbers) {
            int sum1 = 0, sum2 = 0;
            int temp = number;

            for (int i = 0; i < 3; i++) {
                sum1 += temp % 10;
                temp /= 10;
            }

            for (int i = 0; i < 3; i++) {
                sum2 += temp % 10;
                temp /= 10;
            }

            if (sum1 == sum2) {
                System.out.print(number + " ");
            }
        }
    }
}
