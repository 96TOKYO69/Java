package org.example.zadanie1;


import java.util.Stack;

public class StackSwapper {

    /**
     * Меняет содержимое двух стеков местами.
     * @param stack1 Первый стек.
     * @param stack2 Второй стек.
     */
    public static void swapStacks(Stack<Integer> stack1, Stack<Integer> stack2) {
        Stack<Integer> temp = new Stack<>();
        temp.addAll(stack1);
        stack1.clear();
        stack1.addAll(stack2);
        stack2.clear();
        stack2.addAll(temp);
    }
}
