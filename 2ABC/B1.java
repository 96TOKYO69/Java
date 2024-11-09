/**
 * Задача B1: Вывести на экран таблицу умножения.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B1 {
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                System.out.print(i * j + "\t");
            }
            System.out.println(' ');
        }
    }
}
