package org.example;

import java.util.concurrent.ThreadLocalRandom;

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
                Thread.sleep(500);
                stop.depart(id);

                if (i < route.getStopsCount() - 1) {
                    int travelTime = ThreadLocalRandom.current().nextInt(3000, 5001);
                    System.out.printf("Автобус %d едет к остановке %s (%d минут).%n",
                            id, route.getStop(i + 1).getName(), travelTime / 1000);
                    Thread.sleep(travelTime);
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Автобус " + id + " был прерван.");
        }
    }
}
