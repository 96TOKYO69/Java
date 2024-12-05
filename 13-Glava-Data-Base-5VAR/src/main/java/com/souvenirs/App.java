package com.souvenirs;

import com.souvenirs.dao.ManufacturerDAO;
import com.souvenirs.dao.SouvenirDAO;
import com.souvenirs.model.Manufacturer;

public class App {
    public static void main(String[] args) {

        DatabaseSetup.initializeDatabase();

        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        SouvenirDAO souvenirDAO = new SouvenirDAO();

        // Вывести информацию о сувенирах заданного производителя.
        System.out.println("Сувениры производителя 'Производитель А':");
        souvenirDAO.getSouvenirsByManufacturer("Производитель А").forEach(System.out::println);

        // Вывести информацию о сувенирах, произведенных в заданной стране
        System.out.println("\nПроизводители из страны 'Россия':");
        manufacturerDAO.getManufacturersByCountry("Россия").forEach(System.out::println);

        // Вывести производителей, чьи сувениры стоят меньше 1000
        System.out.println("\nПроизводители с сувенирами дешевле 1000:");
        souvenirDAO.getManufacturersByPrice(1000).forEach(System.out::println);

        // Вывести производителей сувенира, произведенного в 2023 году
        System.out.println("\nПроизводители сувениров, выпущенных в 2023 году:");
        souvenirDAO.getManufacturersBySouvenirYear("Сувенир 1", 2023).forEach(System.out::println);

        // Вывести информацию о производителе с id=1 и его сувенирах ДО удаления
        int manufacturerId = 1;
        System.out.println("\nПроизводитель до удаления:");
        Manufacturer manufacturer = manufacturerDAO.getManufacturerById(manufacturerId);
        if (manufacturer != null) {
            System.out.println(manufacturer);
            System.out.println("Сувениры производителя:");
            manufacturerDAO.getSouvenirsByManufacturerId(manufacturerId).forEach(System.out::println);
        }

        // Удалить производителя и его сувениры
        System.out.println("\nУдален производитель с id=1 и его сувениры");
        manufacturerDAO.deleteManufacturerAndSouvenirs(manufacturerId);

        // Попробуем вывести информацию о производителе после удаления
        System.out.println("\nПроизводитель после удаления:");
        manufacturer = manufacturerDAO.getManufacturerById(manufacturerId);
        if (manufacturer == null) {
            System.out.println("Производитель с id=" + manufacturerId + " больше не существует.");
        }
    }
}

