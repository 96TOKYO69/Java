package org.example;

import java.util.*;

public class Department {
    private String departmentName;
    private Map<String, Position> positions;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.positions = new HashMap<>();
    }

    public void addPosition(String positionName) {
        positions.putIfAbsent(positionName, new Position(positionName));
    }

    public void addEmployee(String positionName, String employeeName) {
        Position position = positions.get(positionName);
        if (position == null) {
            throw new IllegalArgumentException("Должность " + positionName + " не существует в отделе.");
        }
        position.addEmployee(employeeName);
    }

    public List<String> getEmployees(String positionName) {
        Position position = positions.get(positionName);
        if (position == null) {
            throw new IllegalArgumentException("Должность " + positionName + " не существует в отделе.");
        }
        return position.getEmployees();
    }

    public void printDepartmentInfo() {
        System.out.println("Отдел: " + departmentName);
        for (Position position : positions.values()) {
            System.out.println("Должность: " + position.getPositionName());
            System.out.println("Сотрудники: " + position.getEmployees());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, positions);
    }

    private static class Position {
        private String positionName;
        private Set<String> employees;

        public Position(String positionName) {
            this.positionName = positionName;
            this.employees = new HashSet<>();
        }

        public String getPositionName() {
            return positionName;
        }

        public void addEmployee(String employeeName) {
            employees.add(employeeName);
        }

        public List<String> getEmployees() {
            return new ArrayList<>(employees);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Objects.equals(positionName, position.positionName) &&
                    Objects.equals(employees, position.employees);
        }

        @Override
        public int hashCode() {
            return Objects.hash(positionName, employees);
        }
    }

    public static void main(String[] args) {
        Department department = new Department("IT Отдел");

        // Добавляем должности
        department.addPosition("Разработчик");
        department.addPosition("Тестировщик");

        // Добавляем сотрудников
        department.addEmployee("Разработчик", "Иван Иванов");
        department.addEmployee("Разработчик", "Алексей Смирнов");
        department.addEmployee("Тестировщик", "Мария Петрова");

        // Печатаем информацию об отделе
        department.printDepartmentInfo();

        // Получаем сотрудников конкретной должности
        System.out.println("Сотрудники на должности 'Разработчик': " + department.getEmployees("Разработчик"));
    }
}
