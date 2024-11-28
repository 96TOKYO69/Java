package org.example;

public class StringComparatorDemo {
    public static void main(String[] args) {
        StringComparator comparator = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;

        System.out.println(comparator.compare("apple", "banana"));
        System.out.println(comparator.compare("cat", "dog"));
    }
}
