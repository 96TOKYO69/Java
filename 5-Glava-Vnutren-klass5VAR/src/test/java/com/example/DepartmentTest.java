package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testAddAndRetrieveEmployees() {
        Department department = new Department("HR");
        department.addPosition("Рекрутер");
        department.addEmployee("Рекрутер", "Анна Иванова");

        List<String> employees = department.getEmployees("Рекрутер");
        assertEquals(1, employees.size());
        assertTrue(employees.contains("Анна Иванова"));
    }

    @Test
    void testAddPosition() {
        Department department = new Department("Finance");
        department.addPosition("Бухгалтер");

        assertDoesNotThrow(() -> department.getEmployees("Бухгалтер"));
    }

    @Test
    void testAddEmployeeToNonexistentPosition() {
        Department department = new Department("Sales");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                department.addEmployee("Менеджер", "Петр Петров")
        );

        assertEquals("Должность Менеджер не существует в отделе.", exception.getMessage());
    }

    @Test
    void testEqualsAndHashCode() {
        Department department1 = new Department("Marketing");
        department1.addPosition("Дизайнер");
        department1.addEmployee("Дизайнер", "Ирина Смирнова");

        Department department2 = new Department("Marketing");
        department2.addPosition("Дизайнер");
        department2.addEmployee("Дизайнер", "Ирина Смирнова");

        assertEquals(department1, department2);
        assertEquals(department1.hashCode(), department2.hashCode());
    }

    @Test
    void testPrintDepartmentInfo() {
        Department department = new Department("Support");
        department.addPosition("Аналитик");
        department.addEmployee("Аналитик", "Сергей Павлов");

        assertDoesNotThrow(department::printDepartmentInfo);
    }
}
