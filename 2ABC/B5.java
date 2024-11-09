/**
 * Задача B5: Сколько значащих нулей в двоичной записи числа 129?
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B5 {
    public static void main(String[] args) {
        int number = 129;
        String binaryString = Integer.toBinaryString(number);
        int significantZeros = 0;
        boolean foundFirstOne = false;

        // Проходим по двоичной строке
        for (int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(i);
            // Проверяем, если нашли первую единицу
            if (bit == '1') {
                foundFirstOne = true;
            } else if (foundFirstOne) {
                // Если нашли ноль после первой единицы, увеличиваем счетчик
                significantZeros++;
            }
        }

        System.out.println("Двоичная запись числа " + number + ": " + binaryString);
        System.out.println("Количество значащих нулей: " + significantZeros);
    }
}
