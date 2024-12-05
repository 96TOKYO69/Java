package com.souvenirs.dao;

import com.souvenirs.DatabaseConnection;
import com.souvenirs.model.Souvenir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SouvenirDAO {

    public List<Souvenir> getSouvenirsByCountry(String country) {
        String query = """
            SELECT s.id, s.name, s.release_date, s.price
            FROM souvenirs s
            JOIN manufacturers m ON s.manufacturer_id = m.id
            WHERE m.country = ?;
            """;
        List<Souvenir> souvenirs = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, country);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Souvenir souvenir = new Souvenir(
                        rs.getInt("id"),
                        rs.getString("name"),
                        0,
                        rs.getString("release_date"),
                        rs.getDouble("price")
                );
                souvenirs.add(souvenir);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirs;
    }

    public List<Souvenir> getSouvenirsByManufacturer(String manufacturerName) {
        String query = """
                SELECT s.id, s.name, s.release_date, s.price
                FROM souvenirs s
                JOIN manufacturers m ON s.manufacturer_id = m.id
                WHERE m.name = ?;
                """;
        List<Souvenir> souvenirs = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, manufacturerName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Souvenir souvenir = new Souvenir(
                        rs.getInt("id"),
                        rs.getString("name"),
                        0,
                        rs.getString("release_date"),
                        rs.getDouble("price")
                );
                souvenirs.add(souvenir);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setDouble(1, maxPrice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                manufacturers.add("Manufacturer: " + rs.getString("name") + ", Country: " + rs.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }


    public List<String> getManufacturersBySouvenirYear(String souvenirName, int year) {
        String query = """
                SELECT m.name, m.country
                FROM manufacturers m
                JOIN souvenirs s ON m.id = s.manufacturer_id
                WHERE s.name = ? AND YEAR(s.release_date) = ?;
                """;
        List<String> manufacturers = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, souvenirName);
            ps.setInt(2, year);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                manufacturers.add("Manufacturer: " + rs.getString("name") + ", Country: " + rs.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    public void deleteManufacturerAndSouvenirs(int manufacturerId) {
        String deleteSouvenirsQuery = "DELETE FROM souvenirs WHERE manufacturer_id = ?;";
        String deleteManufacturerQuery = "DELETE FROM manufacturers WHERE id = ?;";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement deleteSouvenirsStmt = connection.prepareStatement(deleteSouvenirsQuery);
             PreparedStatement deleteManufacturerStmt = connection.prepareStatement(deleteManufacturerQuery)) {

            deleteSouvenirsStmt.setInt(1, manufacturerId);
            deleteSouvenirsStmt.executeUpdate();

            deleteManufacturerStmt.setInt(1, manufacturerId);
            deleteManufacturerStmt.executeUpdate();

            System.out.println("Производитель и связанные с ним сувениры успешно удалены.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
