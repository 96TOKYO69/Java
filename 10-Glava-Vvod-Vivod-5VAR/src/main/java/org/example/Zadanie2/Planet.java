package org.example.Zadanie2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Continent> continents = new ArrayList<>();
    private List<Ocean> oceans = new ArrayList<>();
    private List<Island> islands = new ArrayList<>();

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public void addOcean(Ocean ocean) {
        oceans.add(ocean);
    }

    public void addIsland(Island island) {
        islands.add(island);
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public List<Ocean> getOceans() {
        return oceans;
    }

    public List<Island> getIslands() {
        return islands;
    }

    public void printPlanetInfo() {
        System.out.println("Планета: " + name);
        System.out.println("Количество континентов: " + continents.size());
        System.out.println("Континенты: " + continents);
        System.out.println("Океаны: " + oceans);
        System.out.println("Острова: " + islands);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name) &&
                Objects.equals(continents, planet.continents) &&
                Objects.equals(oceans, planet.oceans) &&
                Objects.equals(islands, planet.islands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, continents, oceans, islands);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", continents=" + continents +
                ", oceans=" + oceans +
                ", islands=" + islands +
                '}';
    }
}
