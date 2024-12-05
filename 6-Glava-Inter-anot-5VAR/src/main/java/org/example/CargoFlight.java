package org.example;

public class CargoFlight implements Flight {
    private String flightNumber;
    private String destination;
    private String aircraftModel;
    private String status;
    private double averageFlightTime;
    private double fuelAmount;
    private double weight;
    private boolean isValuable;
    private boolean isFragile;

    public CargoFlight(String flightNumber, String destination, String model) {
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
            System.out.println("Рейс отправился в пункт назначения: " + destination);
        } else {
            System.out.println("Рейс не может быть отправлен. Текущий статус: " + status);
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
    public boolean isCargoValuable() { return isValuable; }
    public void setCargoValuable(boolean isValuable) { this.isValuable = isValuable; }
    @Override
    public boolean isCargoFragile() { return isFragile; }
    public void setCargoFragile(boolean isFragile) { this.isFragile = isFragile; }
}
