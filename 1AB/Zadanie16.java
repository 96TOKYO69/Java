import java.util.Scanner;

public class Zadanie16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n\nЧисла-палиндромы:");
        for (int number : numbers) {
            int original = number;
            int reversed = 0;
            while (number > 0) {
                int digit = number % 10;
                reversed = reversed * 10 + digit;
                number /= 10;
            }
            if (original == reversed) {
                System.out.print(original + " ");
            }
        }

    }
}
