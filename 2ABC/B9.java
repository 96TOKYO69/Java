import java.util.Scanner;
/**
 * Задача B8: Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер месяца: ");
        if(sc.hasNextInt()){
            int num = sc.nextInt();
            if(num > 0 && num < 13)
                switch(num)
                {
                    case 1:
                        System.out.println("Январь");
                        break;
                    case 2:
                        System.out.println("Февраль");
                        break;
                    case 3:
                        System.out.println("Март");
                        break;
                    case 4:
                        System.out.println("Апрель");
                        break;
                    case 5:
                        System.out.println("Май");
                        break;
                    case 6:
                        System.out.println("Июнь");
                        break;
                    case 7:
                        System.out.println("Июль");
                        break;
                    case 8:
                        System.out.println("Август");
                        break;
                    case 9:
                        System.out.println("Сентябрь");
                        break;
                    case 10:
                        System.out.println("Октябрь");
                        break;
                    case 11:
                        System.out.println("Ноябрь");
                        break;
                    case 12:
                        System.out.println("Декабрь");
                        break;
                    default:
                        System.out.println("Такого месяца нету");
                }
            else
                System.out.println("Введите корректный месяц");
        }
        else
            System.out.println("Введите целое число");
    }
}
