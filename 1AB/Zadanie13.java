import java.util.Scanner;
import java.util.Arrays;

public class Zadanie13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Числа в порядке возрастания:");
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        for (int number : sortedNumbers) {
            System.out.print(number + " ");
        }

        System.out.println("\nЧисла в порядке убывания:");
        Arrays.sort(sortedNumbers);
        for (int i = sortedNumbers.length - 1; i >= 0; i--) {
            System.out.print(sortedNumbers[i] + " ");
        }

    }
}
