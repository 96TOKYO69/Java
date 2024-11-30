package org.example;

public interface Flight {
    String getFlightNumber();
    void setFlightNumber(String flightNumber);

    String getDestination();
    void setDestination(String destination);

    String getAircraftModel();
    void setAircraftModel(String model);

    String getStatus();
    void setStatus(String status);

    double getAverageFlightTime();
    double getFuelAmount();
    double getWeight();

    void sendToDestination();
    void repair();
    void refuel(double fuelAmount);
    void load(double weight);
    void unload(double weight);

    boolean isCargoValuable();
    boolean isCargoFragile();
}
