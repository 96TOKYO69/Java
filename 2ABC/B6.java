/**
 * Задача B6: В системе счисления с некоторым основанием десятичное число 81 записывается в виде 100. Найти это основание.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B6 {
    public static void main(String[] args) {
        int number = 81; // Десятичное число
        int base = findBase(number);

        System.out.println("Основание системы счисления: " + base);
    }

    public static int findBase(int number) {
        return (int) Math.sqrt(number); // Извлекаем квадратный корень
    }
}
