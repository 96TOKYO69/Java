// Случайные цифры с переходом на новую строку и без
import java.util.Random;

public class Zadanie3 {
    public static void main(String[] args) {
        int numNumbers = Integer.parseInt(args[0]);
        Random rand = new Random();

        System.out.println("Вывод с переходом на новую строку:");
        for (int i = 0; i < numNumbers; i++) {
            int randomNumber = rand.nextInt(100);
            System.out.println(randomNumber);
        }

        System.out.println("Вывод без перехода на новую строку:");
        for (int i = 0; i < numNumbers; i++) {
            int randomNumber = rand.nextInt(100);
            System.out.print(randomNumber + " ");
        }

    }
}
