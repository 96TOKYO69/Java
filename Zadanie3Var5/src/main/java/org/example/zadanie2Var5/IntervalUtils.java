package org.example.zadanie2Var5;

import java.util.List;

public class IntervalUtils {

    // Метод для вычисления максимального расстояния между концами интервалов
    public static double maxDistance(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;

        double minStart = intervals.get(0).getStart();
        double maxEnd = intervals.get(0).getEnd();

        for (Interval interval : intervals) {
            if (interval.getStart() < minStart) {
                minStart = interval.getStart();
            }
            if (interval.getEnd() > maxEnd) {
                maxEnd = interval.getEnd();
            }
        }
        return maxEnd - minStart;
    }
}
