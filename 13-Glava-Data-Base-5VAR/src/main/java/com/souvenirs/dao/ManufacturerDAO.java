package com.souvenirs.dao;

import com.souvenirs.DatabaseConnection;
import com.souvenirs.model.Manufacturer;
import com.souvenirs.model.Souvenir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManufacturerDAO {
    private static final Logger LOGGER = Logger.getLogger(ManufacturerDAO.class.getName());
    private final Connection connection;

    public ManufacturerDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Manufacturer> getManufacturersByCountry(String country) {
        String query = "SELECT * FROM manufacturers WHERE country = ?;";
        List<Manufacturer> manufacturers = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, country);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    manufacturers.add(new Manufacturer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("country")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось получить производителей", e);
        }
        return manufacturers;
    }

    public void deleteManufacturerAndSouvenirs(int manufacturerId) {
        String deleteSouvenirsQuery = "DELETE FROM souvenirs WHERE manufacturer_id = ?;";
        String deleteManufacturerQuery = "DELETE FROM manufacturers WHERE id = ?;";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement deleteSouvenirsStmt = connection.prepareStatement(deleteSouvenirsQuery);
                 PreparedStatement deleteManufacturerStmt = connection.prepareStatement(deleteManufacturerQuery)) {

                deleteSouvenirsStmt.setInt(1, manufacturerId);
                deleteSouvenirsStmt.executeUpdate();

                deleteManufacturerStmt.setInt(1, manufacturerId);
                deleteManufacturerStmt.executeUpdate();

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.log(Level.SEVERE, "Ошибка при удалении производителя и сувениров", e);
                throw new RuntimeException("Не удалось удалить производителя", e);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка подключения к базе данных", e);
            throw new RuntimeException("Не удалось подключиться к базе данных", e);
        }
    }

    public Manufacturer getManufacturerById(int manufacturerId) {
        String query = "SELECT * FROM manufacturers WHERE id = ?";
        Manufacturer manufacturer = null;

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, manufacturerId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    manufacturer = new Manufacturer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("country")
                    );
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при получении производителя по ID", e);
            throw new RuntimeException("Не удалось получить производителя", e);
        }
        return manufacturer;
    }

    public List<Souvenir> getSouvenirsByManufacturerId(int manufacturerId) {
        String query = "SELECT * FROM souvenirs WHERE manufacturer_id = ?";
        List<Souvenir> souvenirs = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, manufacturerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    souvenirs.add(new Souvenir(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("manufacturer_id"),
                            rs.getString("release_date"),
                            rs.getDouble("price")
                    ));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при получении сувениров производителя", e);
            throw new RuntimeException("Не удалось получить сувениры", e);
        }
        return souvenirs;
    }
    public List<Manufacturer> getManufacturersBySouvenirAndYear(String souvenirName, String year) {
        String query = "SELECT m.* FROM manufacturers m " +
                "JOIN souvenirs s ON m.id = s.manufacturer_id " +
                "WHERE s.name = ? AND YEAR(s.release_date) = ?;";
        List<Manufacturer> manufacturers = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, souvenirName);
            ps.setString(2, year);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    manufacturers.add(new Manufacturer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("country")
                    ));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при получении производителей по сувениру и году", e);
            throw new RuntimeException("Не удалось получить производителей", e);
        }
        return manufacturers;
    }

}
