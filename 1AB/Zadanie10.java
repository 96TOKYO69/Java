import java.util.Scanner;

public class Zadanie10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Числа, которые делятся на 5 и на 7:");
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println(number);
            }
        }

    }
}
