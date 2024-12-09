package com.souvenirs.dao;

import com.souvenirs.DatabaseConnection;
import com.souvenirs.model.Souvenir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SouvenirDAO {
    private static final Logger LOGGER = Logger.getLogger(SouvenirDAO.class.getName());
    private final Connection connection;

    public SouvenirDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Souvenir> getSouvenirsByCountry(String country) {
        String query = """
            SELECT s.id, s.name, s.release_date, s.price
            FROM souvenirs s
            JOIN manufacturers m ON s.manufacturer_id = m.id
            WHERE m.country = ?;
            """;
        List<Souvenir> souvenirs = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, country);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    souvenirs.add(new Souvenir(
                            rs.getInt("id"),
                            rs.getString("name"),
                            0,
                            rs.getString("release_date"),
                            rs.getDouble("price")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить сувениры", e);
        }
        return souvenirs;
    }

    public List<String> getManufacturersByPrice(double maxPrice) {
        String query = """
            SELECT m.name, m.country
            FROM manufacturers m
            WHERE NOT EXISTS (
                SELECT 1
                FROM souvenirs s
                WHERE s.manufacturer_id = m.id
                AND s.price >= ?
            );
            """;
        List<String> manufacturers = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDouble(1, maxPrice);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    manufacturers.add("Manufacturer: " + rs.getString("name") +
                            ", Country: " + rs.getString("country"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при получении производителей по цене", e);
            throw new RuntimeException("Не удалось получить производителей", e);
        }
        return manufacturers;
    }
}
