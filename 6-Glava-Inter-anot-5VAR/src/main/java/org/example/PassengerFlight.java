package org.example;

public class PassengerFlight implements Flight {
    private String flightNumber;
    private String destination;
    private String aircraftModel;
    private String status;
    private double averageFlightTime;
    private double fuelAmount;
    private double weight;
    private int passengers;

    public PassengerFlight(String flightNumber, String destination, String model) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.aircraftModel = model;
        this.status = "Готов к вылету";
    }

    @Override
    public String getFlightNumber() { return flightNumber; }
    @Override
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    @Override
    public String getDestination() { return destination; }
    @Override
    public void setDestination(String destination) { this.destination = destination; }
    @Override
    public String getAircraftModel() { return aircraftModel; }
    @Override
    public void setAircraftModel(String model) { this.aircraftModel = model; }
    @Override
    public String getStatus() { return status; }
    @Override
    public void setStatus(String status) { this.status = status; }
    @Override
    public double getAverageFlightTime() { return averageFlightTime; }
    @Override
    public double getFuelAmount() { return fuelAmount; }
    @Override
    public double getWeight() { return weight; }

    @Override
    public void sendToDestination() {
        if (status.equals("Готов к вылету")) {
            status = "В пути";
        }
    }

    @Override
    public void repair() { status = "В ремонте"; }
    @Override
    public void refuel(double fuelAmount) { this.fuelAmount += fuelAmount; }
    @Override
    public void load(double weight) { this.weight += weight; }
    @Override
    public void unload(double weight) { this.weight -= weight; }
    @Override
    public boolean isCargoValuable() { return false; }
    @Override
    public boolean isCargoFragile() { return false; }

    public int getPassengers() { return passengers; }
    public void setPassengers(int passengers) { this.passengers = passengers; }
}
