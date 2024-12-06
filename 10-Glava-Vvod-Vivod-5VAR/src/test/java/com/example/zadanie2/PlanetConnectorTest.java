package com.example.zadanie2;
import org.example.Zadanie2.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class PlanetConnectorTest {
    @Test
    void testFileSerializationAndDeserialization() throws IOException, ClassNotFoundException {
        Planet planet = new Planet("Земля");
        planet.addContinent(new Continent("Азия"));
        planet.addOcean(new Ocean("Тихоокеанский"));
        planet.addIsland(new Island("Гренландия"));

        String fileName = "test_planet.ser";

        PlanetConnector.savePlanetToFile(planet, fileName);
        Planet loadedPlanet = PlanetConnector.loadPlanetFromFile(fileName);

        assertEquals(planet, loadedPlanet);
    }
}
