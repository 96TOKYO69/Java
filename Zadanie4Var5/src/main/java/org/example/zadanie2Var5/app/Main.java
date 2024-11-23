package org.example.zadanie2Var5.app;

import org.example.zadanie2Var5.model.*;
import org.example.zadanie2Var5.service.Album;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void printTracks(List<MusicTrack> tracks) {
        tracks.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Album album = new Album();

        album.addTrack(new RockTrack("Bohemian Rhapsody", 5.55));
        album.addTrack(new PopTrack("Thriller", 5.57));
        album.addTrack(new JazzTrack("Take Five", 5.24));
        album.addTrack(new RockTrack("Stairway to Heaven", 8.02));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Показать треки");
            System.out.println("2. Подсчитать общую продолжительность");
            System.out.println("3. Отсортировать по стилю");
            System.out.println("4. Найти трек по длительности");
            System.out.println("5. Выход");
            System.out.print("Выбор: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> printTracks(album.getTracks());
                case 2 -> System.out.println("Общая продолжительность: " + album.getTotalDuration() + " минут");
                case 3 -> {
                    album.sortTracksByStyle();
                    System.out.println("Треки отсортированы по стилю.");
                    printTracks(album.getTracks());
                }
                case 4 -> {
                    System.out.print("Введите минимальную длительность: ");
                    double min = scanner.nextDouble();
                    System.out.print("Введите максимальную длительность: ");
                    double max = scanner.nextDouble();
                    List<MusicTrack> foundTracks = album.findTracksByDuration(min, max);
                    if (foundTracks.isEmpty()) {
                        System.out.println("Треки не найдены в указанном диапазоне.");
                    } else {
                        printTracks(foundTracks);
                    }
                }
                case 5 -> System.out.println("Выход...");
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

