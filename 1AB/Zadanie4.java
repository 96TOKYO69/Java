// Сравнение пароля введенного с командной строки со строкой образцом
public class Zadanie4 {
    public static void main(String[] args) {
        int password = 123;
        int passwordInput = Integer.parseInt(args[0]);

        if (passwordInput == password) {
            System.out.println("Вы ввели верный пароль");
        } else {
            System.out.println("Вы ввели неверный пароль");
        }
    }
}
