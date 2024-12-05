package org.example;

public class Bus extends Thread {
    private final int id;
    private final Route route;

    public Bus(int id, Route route) {
        this.id = id;
        this.route = route;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < route.getStopsCount(); i++) {
                BusStop stop = route.getStop(i);
                stop.arrive(id);
                Thread.sleep(1000);
                stop.depart(id);
            }
        } catch (InterruptedException e) {
            System.err.println("Автобус " + id + " был прерван.");
        }
    }
}
