import java.util.Scanner;

public class Zadanie17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n\nЭлементы, равные полусумме соседних элементов:");
        for (int i = 1; i < numbers.length - 1; i++) {
            if (numbers[i] == (numbers[i-1] + numbers[i+1]) / 2) {
                System.out.print(numbers[i] + " ");
            }
        }

    }
}
