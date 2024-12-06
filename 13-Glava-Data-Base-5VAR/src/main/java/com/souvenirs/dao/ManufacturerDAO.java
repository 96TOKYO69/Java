package com.souvenirs.dao;

import com.souvenirs.DatabaseConnection;
import com.souvenirs.model.Manufacturer;
import com.souvenirs.model.Souvenir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO {

    public List<Manufacturer> getManufacturersByCountry(String country) {
        String query = "SELECT * FROM manufacturers WHERE country = ?;";
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, country);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                manufacturers.add(new Manufacturer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    public void deleteManufacturerAndSouvenirs(int manufacturerId) {
        String deleteSouvenirsQuery = "DELETE FROM souvenirs WHERE manufacturer_id = ?;";
        String deleteManufacturerQuery = "DELETE FROM manufacturers WHERE id = ?;";

        try (Connection connection = DatabaseConnection.getConnection()) {

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
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Manufacturer getManufacturerById(int manufacturerId) {
        String query = "SELECT * FROM manufacturers WHERE id = ?";
        Manufacturer manufacturer = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, manufacturerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                manufacturer = new Manufacturer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("country")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturer;
    }

    public List<Souvenir> getSouvenirsByManufacturerId(int manufacturerId) {
        String query = "SELECT * FROM souvenirs WHERE manufacturer_id = ?";
        List<Souvenir> souvenirs = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, manufacturerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                souvenirs.add(new Souvenir(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("manufacturer_id"),
                        rs.getString("release_date"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souvenirs;
    }

}
