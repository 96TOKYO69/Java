package com.example;

import org.example.PassengerFlight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerFlightTest {

    @Test
    void testPassengerFlightInitialization() {
        PassengerFlight flight = new PassengerFlight("PF456", "London", "Airbus A320");

        assertEquals("PF456", flight.getFlightNumber());
        assertEquals("London", flight.getDestination());
        assertEquals("Airbus A320", flight.getAircraftModel());
        assertEquals("Готов к вылету", flight.getStatus());
    }

    @Test
    void testSendToDestination() {
        PassengerFlight flight = new PassengerFlight("PF456", "London", "Airbus A320");

        flight.sendToDestination();
        assertEquals("В пути", flight.getStatus());
    }

    @Test
    void testPassengerManagement() {
        PassengerFlight flight = new PassengerFlight("PF456", "London", "Airbus A320");

        flight.setPassengers(150);
        assertEquals(150, flight.getPassengers());
    }

    @Test
    void testRefuelAndWeightManagement() {
        PassengerFlight flight = new PassengerFlight("PF456", "London", "Airbus A320");

        flight.refuel(300.0);
        assertEquals(300.0, flight.getFuelAmount());

        flight.load(2000.0);
        assertEquals(2000.0, flight.getWeight());

        flight.unload(500.0);
        assertEquals(1500.0, flight.getWeight());
    }
}
