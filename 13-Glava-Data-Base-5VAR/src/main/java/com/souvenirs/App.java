package com.souvenirs;

import com.souvenirs.dao.ManufacturerDAO;
import com.souvenirs.dao.SouvenirDAO;
import com.souvenirs.model.Manufacturer;
import com.souvenirs.model.Souvenir;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {

        try (Connection connection = DatabaseConnection.getConnection()) {
            ManufacturerDAO manufacturerDAO = new ManufacturerDAO(connection);
            SouvenirDAO souvenirDAO = new SouvenirDAO(connection);

            int manufacturerId = 1;
            List<Souvenir> souvenirsByManufacturer = manufacturerDAO.getSouvenirsByManufacturerId(manufacturerId);
            System.out.println("Сувениры производителя с ID " + manufacturerId + ":");
            souvenirsByManufacturer.forEach(System.out::println);

            String country = "Россия";
            List<Souvenir> souvenirsByCountry = souvenirDAO.getSouvenirsByCountry(country);
            System.out.println("\nСувениры, произведенные в стране " + country + ":");
            souvenirsByCountry.forEach(System.out::println);

            double maxPrice = 1000.0;
            List<String> manufacturersByPrice = souvenirDAO.getManufacturersByPrice(maxPrice);
            System.out.println("\nПроизводители, чьи сувениры стоят меньше " + maxPrice + ":");
            manufacturersByPrice.forEach(System.out::println);

            String souvenirName = "Сувенир 1";
            String year = "2023";
            List<Manufacturer> manufacturersForSouvenir = manufacturerDAO.getManufacturersBySouvenirAndYear(souvenirName, year);
            System.out.println("\nПроизводители сувенира '" + souvenirName + "' произведенного в " + year + ":");
            manufacturersForSouvenir.forEach(System.out::println);

            int manufacturerIdToDelete = 2;
            manufacturerDAO.deleteManufacturerAndSouvenirs(manufacturerIdToDelete);
            System.out.println("\nПроизводитель с ID " + manufacturerIdToDelete + " и его сувениры были удалены.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
