/**
 * Задача B3: Определить принадлежность некоторого значения k интервалам (n, m], [n,m), (n, m), [n, m].
 * Разработчик: Бабалаев
 * Дата получения задания: 21.09.24
 * Дата сдачи задания: 26.09.24
 */
public class B3 {
    public static void main(String[] args) {
        int n = 5; // Начало интервала
        int m = 10; // Конец интервала
        int k = 7; // Проверяемое значение

        boolean inOpenClosed = (k > n && k <= m); // (n, m]
        boolean inClosedOpen = (k >= n && k < m); // [n, m)
        boolean inOpenOpen = (k > n && k < m); // (n, m)
        boolean inClosedClosed = (k >= n && k <= m); // [n, m]

        System.out.println("k принадлежит интервалу (n, m]: " + inOpenClosed);
        System.out.println("k принадлежит интервалу [n, m): " + inClosedOpen);
        System.out.println("k принадлежит интервалу (n, m): " + inOpenOpen);
        System.out.println("k принадлежит интервалу [n, m]: " + inClosedClosed);
    }
}
