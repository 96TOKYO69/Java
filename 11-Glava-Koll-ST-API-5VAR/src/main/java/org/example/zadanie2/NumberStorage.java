package org.example.zadanie2;

import java.util.TreeSet;

public class NumberStorage {
    private final TreeSet<Integer> numbers;

    public NumberStorage() {
        this.numbers = new TreeSet<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void removeNumber(int number) {
        numbers.remove(number);
    }

    public Integer findClosestNumber(int target) {
        if (numbers.isEmpty()) {
            return null;
        }
        Integer lower = numbers.floor(target);
        Integer higher = numbers.ceiling(target);

        if (lower == null) {
            return higher;
        }
        if (higher == null) {
            return lower;
        }
        return (Math.abs(target - lower) <= Math.abs(target - higher)) ? lower : higher;
    }

    public TreeSet<Integer> getNumbers() {
        return new TreeSet<>(numbers);
    }
}
