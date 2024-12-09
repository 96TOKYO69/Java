package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.StringComparator;
import org.junit.jupiter.api.Test;

public class StringComparatorTest {

    @Test
    public void testCompare() {
        StringComparator comparator = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;

        assertEquals("banana", comparator.compare("apple", "banana"));

        assertEquals("elephant", comparator.compare("dog", "elephant"));

        assertEquals("apple", comparator.compare("apple", "pear"));
    }
}
