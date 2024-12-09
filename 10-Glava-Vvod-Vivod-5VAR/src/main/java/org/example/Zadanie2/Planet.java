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

    private transient int cachedObjectCount;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
        resetCache();
    }

    public void addOcean(Ocean ocean) {
        oceans.add(ocean);
        resetCache();
    }

    public void addIsland(Island island) {
        islands.add(island);
        resetCache();
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

    public int getTotalObjectCount() {
        if (cachedObjectCount == 0) {
            cachedObjectCount = continents.size() + oceans.size() + islands.size();
        }
        return cachedObjectCount;
    }

    private void resetCache() {
        cachedObjectCount = 0;
    }

    public void printPlanetInfo() {
        System.out.println("Планета: " + name);
        System.out.println("Количество континентов: " + continents.size());
        System.out.println("Континенты: " + continents);
        System.out.println("Океаны: " + oceans);
        System.out.println("Острова: " + islands);
        System.out.println("Общее количество объектов (материков, океанов, островов): " + getTotalObjectCount());
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
