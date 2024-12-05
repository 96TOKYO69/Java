package com.example.zadanie1;

import org.example.zadanie1.StackSwapper;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackSwapperTest {

    @Test
    void testSwapStacks() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        StackSwapper.swapStacks(stack1, stack2);

        Stack<Integer> expectedStack1 = new Stack<>();
        expectedStack1.push(4);
        expectedStack1.push(5);
        expectedStack1.push(6);

        Stack<Integer> expectedStack2 = new Stack<>();
        expectedStack2.push(1);
        expectedStack2.push(2);
        expectedStack2.push(3);

        assertEquals(expectedStack1, stack1);
        assertEquals(expectedStack2, stack2);
    }
}
