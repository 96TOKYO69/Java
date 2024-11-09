/**
 * Задача A9: Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class A9 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Введите три коэффициента (a, b, c) через командную строку.");
            return;
        }

        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            if (a == 0) {
                System.out.println("Коэффициент a не должен быть равен 0.");
                return;
            }

            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("Уравнение имеет один корень: x = " + x);
            } else {
                System.out.println("Уравнение не имеет действительных корней.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите действительные числа для коэффициентов a, b и c.");
        }
    }
}
