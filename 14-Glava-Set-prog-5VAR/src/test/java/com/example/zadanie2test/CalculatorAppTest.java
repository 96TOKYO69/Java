package com.example.zadanie2test;

import org.example.zadanie2.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorAppTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5.0, calculator.calculate(2.0, 3.0, "+"));
    }

    @Test
    void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(-1.0, calculator.calculate(2.0, 3.0, "-"));
    }

    @Test
    void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(6.0, calculator.calculate(2.0, 3.0, "*"));
    }

    @Test
    void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.calculate(6.0, 3.0, "/"));
    }

}
