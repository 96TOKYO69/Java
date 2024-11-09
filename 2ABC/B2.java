/**
 * Задача B2: Вывести элементы массива в обратном порядке..
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B2 {
    public static void main(String[] args) {
        int[] number = new int[]{12,23,34,45,56,67,78,89,90,101};
        System.out.println("Элементы массива в обратном порядке: " );
        for(int i = number.length-1; i >=0; i--){
            System.out.println(number[i]);
        }
    }
}
