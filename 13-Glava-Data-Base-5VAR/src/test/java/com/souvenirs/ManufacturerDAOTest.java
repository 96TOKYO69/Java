package com.souvenirs;

import com.souvenirs.dao.ManufacturerDAO;
import com.souvenirs.model.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;

public class ManufacturerDAOTest {

    private ManufacturerDAO manufacturerDAO;

    @BeforeEach
    public void setup() {

        manufacturerDAO = new ManufacturerDAO();
        DatabaseSetup.initializeDatabase();
    }

    @Test
    public void testGetManufacturersByCountry() throws SQLException {
        List<Manufacturer> manufacturers = manufacturerDAO.getManufacturersByCountry("Россия");
        assertFalse(manufacturers.isEmpty());
        assertEquals("Производитель А", manufacturers.get(0).getName());
    }

    @Test
    public void testDeleteManufacturerAndSouvenirs() throws SQLException {
        manufacturerDAO.deleteManufacturerAndSouvenirs(1);
        List<Manufacturer> manufacturers = manufacturerDAO.getManufacturersByCountry("Россия");
        assertTrue(manufacturers.isEmpty());
    }
}
