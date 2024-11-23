package org.example.zadanie1Var5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestUnut1 {

    @Test
    void testAddContinent() {
        Planet earth = new Planet("Earth");
        Continent africa = new Continent("Africa");

        earth.addContinent(africa);

        assertEquals(1, earth.getNumberOfContinents());
        assertTrue(earth.getContinents().contains(africa));
    }

    @Test
    void testAddOcean() {
        Planet earth = new Planet("Earth");
        Ocean atlantic = new Ocean("Atlantic Ocean");

        earth.addOcean(atlantic);

        List<Ocean> oceans = earth.getOceans();
        assertEquals(1, oceans.size());
        assertEquals("Atlantic Ocean", oceans.get(0).getName());
    }

    @Test
    void testAddIsland() {
        Planet earth = new Planet("Earth");
        Island greenland = new Island("Greenland");

        earth.addIsland(greenland);

        List<Island> islands = earth.getIslands();
        assertEquals(1, islands.size());
        assertEquals("Greenland", islands.get(0).getName());
    }

    @Test
    void testPlanetEquality() {
        Planet earth1 = new Planet("Earth");
        Planet earth2 = new Planet("Earth");

        earth1.addContinent(new Continent("Asia"));
        earth2.addContinent(new Continent("Asia"));

        assertEquals(earth1, earth2);
    }

    @Test
    void testPlanetInequality() {
        Planet earth = new Planet("Earth");
        Planet mars = new Planet("Mars");

        earth.addContinent(new Continent("Africa"));

        assertNotEquals(earth, mars);
    }

    @Test
    void testToString() {
        Planet earth = new Planet("Earth");
        earth.addContinent(new Continent("Africa"));
        earth.addOcean(new Ocean("Atlantic Ocean"));
        earth.addIsland(new Island("Greenland"));

        String expected = "Planet {name='Earth', continents=[Continent {name='Africa'}], oceans=[Ocean {name='Atlantic Ocean'}], islands=[Island {name='Greenland'}]}";
        assertEquals(expected, earth.toString());
    }
}
