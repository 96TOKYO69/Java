package com.example;

import org.example.CargoFlight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagementTest {

    @Test
    void testCargoFlightInitialization() {
        CargoFlight flight = new CargoFlight("CF123", "New York", "Boeing 747");

        assertEquals("CF123", flight.getFlightNumber());
        assertEquals("New York", flight.getDestination());
        assertEquals("Boeing 747", flight.getAircraftModel());
        assertEquals("Готов к вылету", flight.getStatus());
    }

    @Test
    void testSendToDestination() {
        CargoFlight flight = new CargoFlight("CF123", "New York", "Boeing 747");

        flight.sendToDestination();
        assertEquals("В пути", flight.getStatus());

        flight.sendToDestination(); // Попытка повторного отправления
        assertEquals("В пути", flight.getStatus());
    }

    @Test
    void testRefuelAndLoad() {
        CargoFlight flight = new CargoFlight("CF123", "New York", "Boeing 747");

        flight.refuel(500.0);
        assertEquals(500.0, flight.getFuelAmount());

        flight.load(1000.0);
        assertEquals(1000.0, flight.getWeight());
    }

    @Test
    void testSetCargoProperties() {
        CargoFlight flight = new CargoFlight("CF123", "New York", "Boeing 747");

        flight.setCargoValuable(true);
        flight.setCargoFragile(false);

        assertTrue(flight.isCargoValuable());
        assertFalse(flight.isCargoFragile());
    }
}
