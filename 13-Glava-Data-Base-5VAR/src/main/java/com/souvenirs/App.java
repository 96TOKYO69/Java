package com.souvenirs;

import com.souvenirs.model.Manufacturer;
import com.souvenirs.model.Souvenir;
import com.souvenirs.repository.ManufacturerRepository;
import com.souvenirs.repository.SouvenirRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class App {

    private final ManufacturerRepository manufacturerRepository;
    private final SouvenirRepository souvenirRepository;
    private final DatabaseSetup databaseSetup;

    public App(
            ManufacturerRepository manufacturerRepository,
            SouvenirRepository souvenirRepository,
            DatabaseSetup databaseSetup
    ) {
        this.manufacturerRepository = manufacturerRepository;
        this.souvenirRepository = souvenirRepository;
        this.databaseSetup = databaseSetup;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            databaseSetup.initializeDatabaseInstance();
            demonstrateAllOperations();
        };
    }

    @Transactional
    public void demonstrateAllOperations() {
        // 1. Сувениры заданного производителя
        int manufacturerId = 1;
        List<Souvenir> souvenirsByManufacturer = manufacturerRepository.getSouvenirsByManufacturerId(manufacturerId);
        if (souvenirsByManufacturer.isEmpty()) {
            System.out.println("Нет сувениров для производителя с ID " + manufacturerId);
        } else {
            System.out.println("\nСувениры производителя с ID " + manufacturerId + ":");
            souvenirsByManufacturer.forEach(souvenir -> {
                System.out.println(
                        "ID: " + souvenir.getId() +
                                ", Название: " + souvenir.getName() +
                                ", Производитель: " + souvenir.getManufacturer().getName() +
                                ", Дата выпуска: " + souvenir.getReleaseDate() +
                                ", Цена: " + souvenir.getPrice()
                );
            });
        }

        // 2. Сувениры, произведенные в заданной стране
        String country = "Россия";
        List<Souvenir> souvenirsByCountry = souvenirRepository.getSouvenirsByCountry(country);
        System.out.println("\nСувениры, произведенные в стране " + country + ":");
        souvenirsByCountry.forEach(souvenir -> {
            System.out.println(
                    "Название: " + souvenir.getName() +
                            ", Производитель: " + souvenir.getManufacturer().getName() +
                            ", Цена: " + souvenir.getPrice()
            );
        });

        // 3. Производители, чьи цены на сувениры меньше заданной
        double maxPrice = 1000.0;
        List<Manufacturer> manufacturersByPrice = souvenirRepository.getManufacturersByPrice(maxPrice);
        System.out.println("\nПроизводители, чьи сувениры стоят меньше " + maxPrice + ":");
        manufacturersByPrice.forEach(manufacturer -> {
            System.out.println(
                    "Название: " + manufacturer.getName() +
                            ", Страна: " + manufacturer.getCountry()
            );
        });

        // 4. Производители заданного сувенира, произведенного в заданном году
        String souvenirName = "Сувенир 1";
        int year = 2023;
        List<Manufacturer> manufacturersForSouvenir = manufacturerRepository.getManufacturersBySouvenirAndYear(souvenirName, year);
        System.out.println("\nПроизводители сувенира '" + souvenirName + "' произведенного в " + year + ":");
        manufacturersForSouvenir.forEach(manufacturer -> {
            System.out.println(
                    "Название: " + manufacturer.getName() +
                            ", Страна: " + manufacturer.getCountry()
            );
        });

        // 5. Удаление производителя и его сувениров
        int manufacturerIdToDelete = 1;
        manufacturerRepository.deleteManufacturerAndSouvenirs(manufacturerIdToDelete);
        System.out.println("\nПроизводитель с ID " + manufacturerIdToDelete + " и его сувениры были удалены.");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}