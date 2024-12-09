package org.example.Zadanie3;

public class Main {
    public static void main(String[] args) {

        String filePath = "students.txt";

        StudentProcessor processor = new StudentProcessor();

        try {
            processor.processStudents(filePath);
            System.out.println("Обработка завершена. Проверьте файл \"students.txt\".");
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
