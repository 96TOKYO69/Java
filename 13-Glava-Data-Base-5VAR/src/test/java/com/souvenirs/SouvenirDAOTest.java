package com.souvenirs;

import com.souvenirs.dao.SouvenirDAO;
import com.souvenirs.model.Souvenir;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SouvenirDAOTest {

    private SouvenirDAO souvenirDAO;
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

        souvenirDAO = new SouvenirDAO(mockConnection);
    }

    @Test
    public void testGetSouvenirsByCountry() throws SQLException {
        String country = "Россия";
        Souvenir souvenir1 = new Souvenir(1, "Сувенир 1", 1, "2020-01-01", 10.0);
        Souvenir souvenir2 = new Souvenir(2, "Сувенир 2", 1, "2021-01-01", 20.0);

        when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(1).thenReturn(2);
        when(mockResultSet.getString("name")).thenReturn("Сувенир 1").thenReturn("Сувенир 2");
        when(mockResultSet.getString("release_date")).thenReturn("2020-01-01").thenReturn("2021-01-01");
        when(mockResultSet.getDouble("price")).thenReturn(10.0).thenReturn(20.0);

        List<Souvenir> souvenirs = souvenirDAO.getSouvenirsByCountry(country);

        assertNotNull(souvenirs);
        assertEquals(2, souvenirs.size());
        assertEquals("Сувенир 1", souvenirs.get(0).getName());
        assertEquals("Сувенир 2", souvenirs.get(1).getName());
    }

    @Test
    public void testGetManufacturersByPrice() throws SQLException {
        double maxPrice = 15.0;

        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("name")).thenReturn("Производитель 1");
        when(mockResultSet.getString("country")).thenReturn("Россия");

        List<String> manufacturers = souvenirDAO.getManufacturersByPrice(maxPrice);

        assertNotNull(manufacturers);
        assertEquals(1, manufacturers.size());
        assertEquals("Manufacturer: Производитель 1, Country: Россия", manufacturers.get(0));

    }

    @Test
    public void testGetSouvenirsByCountry_SQLException() throws SQLException {
        String country = "Россия";

        when(mockConnection.prepareStatement(anyString())).thenThrow(new SQLException("Ошибка SQL"));

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> souvenirDAO.getSouvenirsByCountry(country));

        assertEquals("Не удалось получить сувениры", thrown.getMessage());
    }
}
