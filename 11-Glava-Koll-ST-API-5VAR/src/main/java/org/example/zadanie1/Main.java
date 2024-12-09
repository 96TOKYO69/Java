package org.example.zadanie1;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        System.out.println("До обмена:");
        System.out.println("Stack 1: " + stack1);
        System.out.println("Stack 2: " + stack2);

        StackSwapper.swapStacks(stack1, stack2);

        System.out.println("После обмена:");
        System.out.println("Stack 1: " + stack1);
        System.out.println("Stack 2: " + stack2);
    }
}
