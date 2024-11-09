import java.util.Scanner;

public class Zadanie11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n\nТрехзначные числа без повторяющихся цифр:");
        for (int number : numbers) {
            if (number >= 100 && number <= 999) {
                String numStr = String.valueOf(number);
                if (numStr.charAt(0) != numStr.charAt(1) &&
                        numStr.charAt(0) != numStr.charAt(2) &&
                        numStr.charAt(1) != numStr.charAt(2)) {
                    System.out.print(number + " ");
                }
            }
        }
    }
}
