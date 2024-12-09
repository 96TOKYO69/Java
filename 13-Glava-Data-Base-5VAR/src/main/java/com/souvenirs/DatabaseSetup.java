package com.souvenirs;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS souvenirs;");
            statement.execute("DROP TABLE IF EXISTS manufacturers;");

            statement.execute("""
                CREATE TABLE manufacturers (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    country VARCHAR(255) NOT NULL
                );
            """);

            statement.execute("""
                CREATE TABLE souvenirs (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    manufacturer_id INT NOT NULL,
                    release_date DATE NOT NULL,
                    price DOUBLE NOT NULL,
                    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id) ON DELETE CASCADE
                );
            """);

            statement.execute("""
                INSERT INTO manufacturers (name, country) VALUES
                ('Производитель А', 'Россия'),
                ('Производитель Б', 'Казахстан'),
                ('Производитель В', 'Беларусь');
            """);

            statement.execute("""
                INSERT INTO souvenirs (name, manufacturer_id, release_date, price) VALUES
                ('Сувенир 1', 1, '2023-01-15', 500.0),
                ('Сувенир 2', 1, '2023-03-20', 750.0),
                ('Сувенир 3', 2, '2022-11-05', 1200.0),
                ('Сувенир 4', 2, '2022-02-10', 1100.0),
                ('Сувенир 5', 3, '2021-07-25', 450.0);
            """);

            System.out.println("База данных инициализирована и заполнена данными");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось инициализировать базу данных.", e);
        }
    }
}
