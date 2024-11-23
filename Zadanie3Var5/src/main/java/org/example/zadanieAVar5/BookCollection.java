package org.example.zadanieAVar5;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // a) Список книг заданного автора
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // b) Список книг заданного издательства
    public List<Book> getBooksByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    // c) Список книг, выпущенных после заданного года
    public List<Book> getBooksAfterYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }
        return result;
    }

    // Метод для вывода списка книг
    public void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
