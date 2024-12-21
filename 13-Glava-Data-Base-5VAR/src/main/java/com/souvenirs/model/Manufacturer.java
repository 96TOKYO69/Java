package com.souvenirs.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {
    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Souvenir> souvenirs;

    public Manufacturer() {}

    public Manufacturer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public List<Souvenir> getSouvenirs() { return souvenirs; }
    public void setSouvenirs(List<Souvenir> souvenirs) { this.souvenirs = souvenirs; }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}