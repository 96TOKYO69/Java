package com.souvenirs;

import com.souvenirs.model.Manufacturer;
import com.souvenirs.model.Souvenir;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class DatabaseSetup {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void initializeDatabaseInstance() {

        entityManager.createQuery("DELETE FROM Souvenir").executeUpdate();
        entityManager.createQuery("DELETE FROM Manufacturer").executeUpdate();


        Manufacturer manufacturerA = new Manufacturer();
        manufacturerA.setId(1);
        manufacturerA.setName("Производитель А");
        manufacturerA.setCountry("Россия");
        entityManager.merge(manufacturerA);

        Manufacturer manufacturerB = new Manufacturer();
        manufacturerB.setId(2);
        manufacturerB.setName("Производитель Б");
        manufacturerB.setCountry("Казахстан");
        entityManager.merge(manufacturerB);

        Manufacturer manufacturerC = new Manufacturer();
        manufacturerC.setId(3);
        manufacturerC.setName("Производитель В");
        manufacturerC.setCountry("Беларусь");
        entityManager.merge(manufacturerC);

        Souvenir souvenir1 = new Souvenir();
        souvenir1.setId(1);
        souvenir1.setName("Сувенир 1");
        souvenir1.setManufacturer(manufacturerA);
        souvenir1.setReleaseDate(LocalDate.of(2023, 1, 15));
        souvenir1.setPrice(500.0);
        entityManager.merge(souvenir1);

        Souvenir souvenir2 = new Souvenir();
        souvenir2.setId(2);
        souvenir2.setName("Сувенир 2");
        souvenir2.setManufacturer(manufacturerA);
        souvenir2.setReleaseDate(LocalDate.of(2023, 3, 20));
        souvenir2.setPrice(750.0);
        entityManager.merge(souvenir2);

        Souvenir souvenir3 = new Souvenir();
        souvenir3.setId(3);
        souvenir3.setName("Сувенир 3");
        souvenir3.setManufacturer(manufacturerB);
        souvenir3.setReleaseDate(LocalDate.of(2022, 11, 5));
        souvenir3.setPrice(1200.0);
        entityManager.merge(souvenir3);

        Souvenir souvenir4 = new Souvenir();
        souvenir4.setId(4);
        souvenir4.setName("Сувенир 4");
        souvenir4.setManufacturer(manufacturerB);
        souvenir4.setReleaseDate(LocalDate.of(2022, 2, 10));
        souvenir4.setPrice(1100.0);
        entityManager.merge(souvenir4);

        Souvenir souvenir5 = new Souvenir();
        souvenir5.setId(5);
        souvenir5.setName("Сувенир 5");
        souvenir5.setManufacturer(manufacturerC);
        souvenir5.setReleaseDate(LocalDate.of(2021, 7, 25));
        souvenir5.setPrice(450.0);
        entityManager.merge(souvenir5);

        entityManager.flush();
        entityManager.clear();

        System.out.println("База данных инициализирована и заполнена данными");
    }
}