package com.souvenirs;

import com.souvenirs.model.Manufacturer;
import com.souvenirs.model.Souvenir;
import com.souvenirs.repository.ManufacturerRepository;
import com.souvenirs.repository.SouvenirRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = "com.souvenirs")
@ActiveProfiles("test")
public class RepositoryTests {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private SouvenirRepository souvenirRepository;

    @Autowired
    private EntityManager entityManager;

    private Manufacturer manufacturer1;
    private Manufacturer manufacturer2;
    private Souvenir souvenir1;
    private Souvenir souvenir2;

    @BeforeEach
    void setUp() {
        entityManager.createQuery("DELETE FROM Souvenir").executeUpdate();
        entityManager.createQuery("DELETE FROM Manufacturer").executeUpdate();

        manufacturer1 = new Manufacturer();
        manufacturer1.setId(1);
        manufacturer1.setName("Тестовый производитель 1");
        manufacturer1.setCountry("Россия");
        entityManager.persist(manufacturer1);

        manufacturer2 = new Manufacturer();
        manufacturer2.setId(2);
        manufacturer2.setName("Тестовый производитель 2");
        manufacturer2.setCountry("Казахстан");
        entityManager.persist(manufacturer2);

        souvenir1 = new Souvenir();
        souvenir1.setId(1);
        souvenir1.setName("Тестовый сувенир 1");
        souvenir1.setManufacturer(manufacturer1);
        souvenir1.setReleaseDate(LocalDate.of(2023, 1, 1));
        souvenir1.setPrice(500.0);
        entityManager.persist(souvenir1);

        souvenir2 = new Souvenir();
        souvenir2.setId(2);
        souvenir2.setName("Тестовый сувенир 2");
        souvenir2.setManufacturer(manufacturer2);
        souvenir2.setReleaseDate(LocalDate.of(2023, 2, 1));
        souvenir2.setPrice(1200.0);
        entityManager.persist(souvenir2);

        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void testGetSouvenirsByManufacturerId() {

        List<Souvenir> souvenirs = manufacturerRepository.getSouvenirsByManufacturerId(1);

        assertNotNull(souvenirs);
        assertEquals(1, souvenirs.size());
        assertEquals("Тестовый сувенир 1", souvenirs.get(0).getName());
        assertEquals(manufacturer1.getName(), souvenirs.get(0).getManufacturer().getName());
    }

    @Test
    void testGetManufacturerById() {
        Manufacturer manufacturer = manufacturerRepository.getManufacturerById(1);

        assertNotNull(manufacturer);
        assertEquals("Тестовый производитель 1", manufacturer.getName());
        assertEquals("Россия", manufacturer.getCountry());
    }

    @Test
    void testGetSouvenirsByCountry() {
        List<Souvenir> souvenirs = souvenirRepository.getSouvenirsByCountry("Россия");

        assertNotNull(souvenirs);
        assertEquals(1, souvenirs.size());
        assertEquals("Тестовый сувенир 1", souvenirs.get(0).getName());
    }

    @Test
    void testGetManufacturersByPrice() {

        List<Manufacturer> manufacturers = souvenirRepository.getManufacturersByPrice(1000.0);

        assertNotNull(manufacturers);
        assertEquals(1, manufacturers.size());
        assertEquals("Тестовый производитель 1", manufacturers.get(0).getName());
    }

    @Test
    void testGetManufacturersBySouvenirAndYear() {

        List<Manufacturer> manufacturers = manufacturerRepository
                .getManufacturersBySouvenirAndYear("Тестовый сувенир 1", 2023);

        assertNotNull(manufacturers);
        assertEquals(1, manufacturers.size());
        assertEquals("Тестовый производитель 1", manufacturers.get(0).getName());
    }

    @Test
    void testDeleteManufacturerAndSouvenirs() {

        manufacturerRepository.deleteManufacturerAndSouvenirs(1);
        entityManager.flush();
        entityManager.clear();

        Manufacturer deletedManufacturer = manufacturerRepository.getManufacturerById(1);
        List<Souvenir> remainingSouvenirs = manufacturerRepository.getSouvenirsByManufacturerId(1);

        assertNull(deletedManufacturer);
        assertTrue(remainingSouvenirs.isEmpty());
    }

    @Test
    void testManufacturerNotFound() {

        List<Souvenir> souvenirs = manufacturerRepository.getSouvenirsByManufacturerId(999);

        assertNotNull(souvenirs);
        assertTrue(souvenirs.isEmpty());
    }

    @Test
    void testNoSouvenirsInCountry() {

        List<Souvenir> souvenirs = souvenirRepository.getSouvenirsByCountry("Германия");

        assertNotNull(souvenirs);
        assertTrue(souvenirs.isEmpty());
    }
}