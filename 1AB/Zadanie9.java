import java.util.Scanner;
public class Zadanie9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Числа, которые делятся на 3 или на 9:");
        for (int number : numbers) {
            if (number % 3 == 0 || number % 9 == 0) {
                System.out.println(number);
            }
        }

    }
}
