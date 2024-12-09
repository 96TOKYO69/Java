package com.souvenirs;

import com.souvenirs.dao.ManufacturerDAO;
import com.souvenirs.model.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ManufacturerDAOTest {

    private ManufacturerDAO manufacturerDAO;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws SQLException {
        mockConnection = Mockito.mock(Connection.class);
        mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        mockResultSet = Mockito.mock(ResultSet.class);

        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        manufacturerDAO = new ManufacturerDAO(mockConnection);
    }

    @Test
    public void testGetManufacturersByCountry() throws SQLException {
        String country = "Россия";
        Manufacturer manufacturer1 = new Manufacturer(1, "Производитель 1", country);
        Manufacturer manufacturer2 = new Manufacturer(2, "Производитель 2", country);

        when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(1).thenReturn(2);
        when(mockResultSet.getString("name")).thenReturn("Производитель 1").thenReturn("Производитель 2");
        when(mockResultSet.getString("country")).thenReturn(country);

        List<Manufacturer> manufacturers = manufacturerDAO.getManufacturersByCountry(country);

        assertNotNull(manufacturers);
        assertEquals(2, manufacturers.size());
        assertEquals("Производитель 1", manufacturers.get(0).getName());
        assertEquals("Производитель 2", manufacturers.get(1).getName());
    }

    @Test
    public void testGetManufacturerById() throws SQLException {
        int manufacturerId = 1;
        Manufacturer manufacturer = new Manufacturer(manufacturerId, "Производитель 1", "Россия");

        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(manufacturerId);
        when(mockResultSet.getString("name")).thenReturn("Производитель 1");
        when(mockResultSet.getString("country")).thenReturn("Россия");

        Manufacturer result = manufacturerDAO.getManufacturerById(manufacturerId);

        assertNotNull(result);
        assertEquals(manufacturerId, result.getId());
        assertEquals("Производитель 1", result.getName());
    }

    @Test
    public void testGetManufacturersBySouvenirAndYear() throws SQLException {
        String souvenirName = "Сувенир 1";
        String year = "2020";
        Manufacturer manufacturer = new Manufacturer(1, "Производитель 1", "Россия");

        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("Производитель 1");
        when(mockResultSet.getString("country")).thenReturn("Россия");

        List<Manufacturer> manufacturers = manufacturerDAO.getManufacturersBySouvenirAndYear(souvenirName, year);

        assertNotNull(manufacturers);
        assertEquals(1, manufacturers.size());
        assertEquals("Производитель 1", manufacturers.get(0).getName());
    }
}
