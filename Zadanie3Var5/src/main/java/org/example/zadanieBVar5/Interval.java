package org.example.zadanieBVar5;

public class Interval {
    private double start;
    private double end;
    private boolean startInclusive;
    private boolean endInclusive;

    // Конструктор
    public Interval(double start, double end, boolean startInclusive, boolean endInclusive) {
        if (start > end) {
            throw new IllegalArgumentException("Начало интервала должно быть меньше или равно концу.");
        }
        this.start = start;
        this.end = end;
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    // Методы доступа
    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public boolean isStartInclusive() {
        return startInclusive;
    }

    public boolean isEndInclusive() {
        return endInclusive;
    }

    // Метод пересечения интервалов
    public Interval intersect(Interval other) {
        double newStart = Math.max(this.start, other.start);
        double newEnd = Math.min(this.end, other.end);

        boolean newStartInclusive = (newStart == this.start ? this.startInclusive : other.startInclusive) &&
                (newStart == other.start ? other.startInclusive : this.startInclusive);

        boolean newEndInclusive = (newEnd == this.end ? this.endInclusive : other.endInclusive) &&
                (newEnd == other.end ? other.endInclusive : this.endInclusive);

        if (newStart < newEnd || (newStart == newEnd && newStartInclusive && newEndInclusive)) {
            return new Interval(newStart, newEnd, newStartInclusive, newEndInclusive);
        } else {
            return null; // Нет пересечения
        }
    }

    // Метод объединения интервалов
    public Interval union(Interval other) {
        if (this.end < other.start || this.start > other.end) {
            return null; // Нет общего промежутка для объединения
        }

        double newStart = Math.min(this.start, other.start);
        double newEnd = Math.max(this.end, other.end);

        boolean newStartInclusive = (newStart == this.start ? this.startInclusive : other.startInclusive) &&
                (newStart == other.start ? other.startInclusive : this.startInclusive);

        boolean newEndInclusive = (newEnd == this.end ? this.endInclusive : other.endInclusive) &&
                (newEnd == other.end ? other.endInclusive : this.endInclusive);

        return new Interval(newStart, newEnd, newStartInclusive, newEndInclusive);
    }

    // Арифметические операции
    public Interval add(double value) {
        return new Interval(this.start + value, this.end + value, this.startInclusive, this.endInclusive);
    }

    public Interval subtract(double value) {
        return new Interval(this.start - value, this.end - value, this.startInclusive, this.endInclusive);
    }

    public Interval multiply(double value) {
        if (value < 0) {
            return new Interval(this.end * value, this.start * value, this.endInclusive, this.startInclusive);
        }
        return new Interval(this.start * value, this.end * value, this.startInclusive, this.endInclusive);
    }

    public Interval divide(double value) {
        if (value == 0) {
            throw new ArithmeticException("Деление на ноль.");
        }
        if (value < 0) {
            return new Interval(this.end / value, this.start / value, this.endInclusive, this.startInclusive);
        }
        return new Interval(this.start / value, this.end / value, this.startInclusive, this.endInclusive);
    }

    @Override
    public String toString() {
        return (startInclusive ? "[" : "(") + start + ", " + end + (endInclusive ? "]" : ")");
    }
}
