package org.example.zadanie2Var5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание интервалов
        Interval interval1 = new Interval(1, 5, true, false);
        Interval interval2 = new Interval(3, 7, true, true);

        // Пересечения
        System.out.println("Пересечение: " + interval1.intersect(interval2));

        // Объединения
        System.out.println("Объединение: " + interval1.union(interval2));

        // Создание списка интервалов
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(new Interval(10, 15, true, false));

        // Вычисление максимального расстояния между самыми удаленными концами
        System.out.println("Максимальное расстояние: " + IntervalUtils.maxDistance(intervals));
    }
}
