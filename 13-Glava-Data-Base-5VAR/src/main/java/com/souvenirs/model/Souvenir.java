package com.souvenirs.model;

public class Souvenir {
    private int id;
    private String name;
    private int manufacturerId;
    private String releaseDate;
    private double price;

    public Souvenir(int id, String name, int manufacturerId, String releaseDate, double price) {
        this.id = id;
        this.name = name;
        this.manufacturerId = manufacturerId;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public Souvenir() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturerId=" + manufacturerId +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                '}';
    }
}
