package com.souvenirs;

import com.souvenirs.dao.SouvenirDAO;
import com.souvenirs.model.Souvenir;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;

public class SouvenirDAOTest {

    private SouvenirDAO souvenirDAO;

    @BeforeEach
    public void setup() {
        // Инициализация DAO
        souvenirDAO = new SouvenirDAO();

        // Создание базы данных перед каждым тестом
        DatabaseSetup.initializeDatabase();
    }

    @Test
    public void testGetSouvenirsByCountry() throws SQLException {
        List<Souvenir> souvenirs = souvenirDAO.getSouvenirsByCountry("Россия");
        assertFalse(souvenirs.isEmpty());
        assertEquals("Сувенир 1", souvenirs.get(0).getName());
    }

    @Test
    public void testGetManufacturersByPrice() throws SQLException {
        List<String> manufacturers = souvenirDAO.getManufacturersByPrice(1000);
        assertFalse(manufacturers.isEmpty());
        assertTrue(manufacturers.get(0).contains("Производитель А"));
    }

    @Test
    public void testDeleteManufacturerAndSouvenirs() throws SQLException {
        souvenirDAO.deleteManufacturerAndSouvenirs(1);
        List<Souvenir> souvenirs = souvenirDAO.getSouvenirsByManufacturer("Производитель А");
        assertTrue(souvenirs.isEmpty());
    }
}
