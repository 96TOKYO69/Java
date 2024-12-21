package com.souvenirs.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "souvenirs")
public class Souvenir {
    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "price", nullable = false)
    private double price;

    public Souvenir() {}

    public Souvenir(int id, String name, Manufacturer manufacturer, LocalDate releaseDate, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Manufacturer getManufacturer() { return manufacturer; }
    public void setManufacturer(Manufacturer manufacturer) { this.manufacturer = manufacturer; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Souvenir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer.getName() +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }
}