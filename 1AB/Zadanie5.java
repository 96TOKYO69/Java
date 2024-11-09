// Подсчет суммы и произведения
public class Zadanie5 {
    public static void main(String[] args) {

        int numArgs = Integer.parseInt(args[0]);
        int[] numbers = new int[numArgs];

        for (int i = 0; i < numArgs; i++) {
            numbers[i] = Integer.parseInt(args[i + 1]);
        }

        int sum = 0;
        int product = 1;

        for (int num : numbers) {
            sum = sum + num;
            product = product * num;
        }

        System.out.println("Сумма целых чисел: " + sum);
        System.out.println("Произведение целых чисел: " + product);
    }
}
