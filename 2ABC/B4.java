/**
 * Задача B4: Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B4 {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++)
        {
            if(i % 3 ==0)
            {
                System.out.println(i);
            }
        }
    }
}
