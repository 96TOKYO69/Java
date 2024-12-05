package org.example.Zadanie2;

import java.io.*;

public class PlanetConnector {
    public static void savePlanetToFile(Planet planet, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(planet);
        }
    }

    public static Planet loadPlanetFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Planet) ois.readObject();
        }
    }
}
