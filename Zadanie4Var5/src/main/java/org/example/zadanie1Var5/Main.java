package org.example.zadanie1Var5;

public class Main {
    public static void main(String[] args) {
        // Создаем планету
        Planet earth = new Planet("Earth");

        // Добавляем материки
        earth.addContinent(new Continent("Africa"));
        earth.addContinent(new Continent("Asia"));
        earth.addContinent(new Continent("Europe"));

        // Добавляем океаны
        earth.addOcean(new Ocean("Atlantic Ocean"));
        earth.addOcean(new Ocean("Pacific Ocean"));

        // Добавляем острова
        earth.addIsland(new Island("Greenland"));
        earth.addIsland(new Island("Madagascar"));

        // Вывод информации
        System.out.println("Название планеты: " + earth.getName());
        System.out.println("Количество материков: " + earth.getNumberOfContinents());
        System.out.println("Список материков:");
        for (Continent continent : earth.getContinents()) {
            System.out.println(" - " + continent.getName());
        }
    }
}