package com.example.zadanie2;

import org.example.zadanie2.NumberStorage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberStorageTest {

    @Test
    public void testAddNumber() {
        NumberStorage storage = new NumberStorage();
        storage.addNumber(10);
        assertTrue(storage.getNumbers().contains(10));
    }

    @Test
    public void testRemoveNumber() {
        NumberStorage storage = new NumberStorage();
        storage.addNumber(10);
        storage.removeNumber(10);
        assertFalse(storage.getNumbers().contains(10));
    }

    @Test
    public void testFindClosestNumber() {
        NumberStorage storage = new NumberStorage();
        storage.addNumber(10);
        storage.addNumber(20);
        storage.addNumber(30);

        assertEquals(20, storage.findClosestNumber(25));
        assertEquals(10, storage.findClosestNumber(15));
        assertEquals(30, storage.findClosestNumber(35));
    }

    @Test
    public void testFindClosestNumberWithEmptyStorage() {
        NumberStorage storage = new NumberStorage();
        assertNull(storage.findClosestNumber(25));
    }
}
