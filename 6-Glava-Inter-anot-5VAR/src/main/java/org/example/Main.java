package org.example;

public class Main {
    public static void main(String[] args) {
        CargoFlight cargoFlight = new CargoFlight("CF123", "Москва", "Boeing 747");
        cargoFlight.setCargoValuable(true);
        cargoFlight.setCargoFragile(false);
        cargoFlight.refuel(5000);
        cargoFlight.load(20000);

        System.out.println("Грузовой рейс:");
        System.out.println("Номер рейса: " + cargoFlight.getFlightNumber());
        System.out.println("Пункт назначения: " + cargoFlight.getDestination());
        System.out.println("Текущий статус: " + cargoFlight.getStatus());
        cargoFlight.sendToDestination();

        PassengerFlight passengerFlight = new PassengerFlight("PF456", "Париж", "Airbus A320");
        passengerFlight.setPassengers(180);
        passengerFlight.refuel(4000);

        System.out.println("\nПассажирский рейс:");
        System.out.println("Номер рейса: " + passengerFlight.getFlightNumber());
        System.out.println("Пункт назначения: " + passengerFlight.getDestination());
        System.out.println("Текущий статус: " + passengerFlight.getStatus());
        passengerFlight.sendToDestination();
    }
}
