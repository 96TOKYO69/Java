import java.util.Scanner;
/**
 * Задача B8: Написать код программы, которая бы переводила числа одной любой системы счисления в любую другую.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        String number = scanner.next();

        System.out.print("Введите основание исходной системы счисления (2-36): ");
        int sourceBase = scanner.nextInt();

        System.out.print("Введите основание целевой системы счисления (2-36): ");
        int targetBase = scanner.nextInt();

        if (sourceBase < 2 || sourceBase > 36 || targetBase < 2 || targetBase > 36) {
            System.out.println("Недопустимое основание. Пожалуйста, введите значения от 2 до 36.");
        } else {
            // Перевод в десятичную систему
            int decimalValue = 0;
            for (int i = 0; i < number.length(); i++) {
                char digitChar = number.charAt(i);
                int digitValue;

                // Определяем значение цифры в 10-ичной системе
                if (digitChar >= '0' && digitChar <= '9') {
                    digitValue = digitChar - '0';
                } else {
                    digitValue = digitChar - 'A' + 10;
                }

                if (digitValue >= sourceBase) {
                    System.out.println("Некорректный символ для основания " + sourceBase);
                    return;
                }

                decimalValue = decimalValue * sourceBase + digitValue;
            }

            // Перевод из десятичной системы в целевую систему
            String result = "";
            int temp = decimalValue;

            while (temp > 0) {
                int remainder = temp % targetBase;
                char digitChar;

                if (remainder < 10) {
                    digitChar = (char) (remainder + '0');
                } else {
                    digitChar = (char) (remainder - 10 + 'A');
                }

                result = digitChar + result;
                temp = temp / targetBase;
            }

            System.out.println("Результат в системе с основанием " + targetBase + ": " + result);
        }

        scanner.close();
    }
}
