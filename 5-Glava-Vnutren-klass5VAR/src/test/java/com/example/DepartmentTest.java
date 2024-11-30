package com.example;

import org.example.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department("IT Отдел");
    }

    @Test
    void testAddPosition() {
        department.addPosition("Разработчик");
        List<String> employees = department.getEmployees("Разработчик");
        assertTrue(employees.isEmpty(), "Ожидался пустой список сотрудников для новой должности");
    }


    @Test
    void testAddEmployeeToExistingPosition() {
        department.addPosition("Тестировщик");
        department.addEmployee("Тестировщик", "Мария Петрова");

        List<String> employees = department.getEmployees("Тестировщик");
        assertEquals(1, employees.size());
        assertTrue(employees.contains("Мария Петрова"));
    }

    @Test
    void testAddEmployeeToNonExistingPosition() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                department.addEmployee("Аналитик", "Иван Иванов")
        );
        assertEquals("Должность Аналитик не существует в отделе.", exception.getMessage());
    }

    @Test
    void testGetEmployeesForNonExistingPosition() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                department.getEmployees("Менеджер")
        );
        assertEquals("Должность Менеджер не существует в отделе.", exception.getMessage());
    }

    @Test
    void testDuplicateEmployeeNotAdded() {
        department.addPosition("Разработчик");
        department.addEmployee("Разработчик", "Иван Иванов");
        department.addEmployee("Разработчик", "Иван Иванов");

        List<String> employees = department.getEmployees("Разработчик");
        assertEquals(1, employees.size());
        assertTrue(employees.contains("Иван Иванов"));
    }

    @Test
    void testPrintDepartmentInfo() {
        department.addPosition("Разработчик");
        department.addEmployee("Разработчик", "Иван Иванов");
        department.addPosition("Тестировщик");

        department.printDepartmentInfo();
    }
}
