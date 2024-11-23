package org.example.zadanieAVar5;

public class Main {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        // Добавление книг
        collection.addBook(new Book(1, "Основы Java", "Иван Иванов", "TechBooks", 2021, 250, 29.99, "Твердый переплет"));
        collection.addBook(new Book(2, "Продвинутая Java", "Иван Иванов", "TechBooks", 2023, 300, 39.99, "Твердый переплет"));
        collection.addBook(new Book(3, "Структуры данных", "Мария Смирнова", "SciencePress", 2018, 200, 25.99, "Мягкий переплет"));
        collection.addBook(new Book(4, "Алгоритмы", "Мария Смирнова", "TechBooks", 2022, 400, 49.99, "Твердый переплет"));

        // a) Книги заданного автора
        System.out.println("Книги Ивана Иванова:");
        collection.printBooks(collection.getBooksByAuthor("Иван Иванов"));

        // b) Книги заданного издательства
        System.out.println("\nКниги, изданные TechBooks:");
        collection.printBooks(collection.getBooksByPublisher("TechBooks"));

        // c) Книги, выпущенные после заданного года
        System.out.println("\nКниги, выпущенные после 2020 года:");
        collection.printBooks(collection.getBooksAfterYear(2020));
    }
}
