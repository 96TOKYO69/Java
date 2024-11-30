package org.example.Zadanie2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Planet
        Planet planet = new Planet("Земля");
        planet.addContinent(new Continent("Азия"));
        planet.addContinent(new Continent("Африка"));
        planet.addOcean(new Ocean("Тихоокеанский"));
        planet.addOcean(new Ocean("Атлантический"));
        planet.addIsland(new Island("Мадагаскар"));

        String fileName = "planet.ser"; // Имя файла для сохранения

        try {
            // Сохраняем объект в файл
            PlanetConnector.savePlanetToFile(planet, fileName);
            System.out.println("Планета, сохраненная в файл: " + fileName);

            // Загружаем объект из файла
            Planet loadedPlanet = PlanetConnector.loadPlanetFromFile(fileName);
            System.out.println("Планета, загруженная из файла: " + loadedPlanet);

            // Вывод информации о планете
            loadedPlanet.printPlanetInfo();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
