package org.example;

import java.util.concurrent.Semaphore;

public class BusStop {
    private final Semaphore semaphore;

    public BusStop(int capacity) {
        this.semaphore = new Semaphore(capacity);
    }

    public void arrive(int busId) throws InterruptedException {
        System.out.println("Автобус " + busId + " ожидает на остановке.");
        semaphore.acquire();
        System.out.println("Автобус " + busId + " остановился.");
    }

    public void depart(int busId) {
        System.out.println("Автобус " + busId + " покидает остановку.");
        semaphore.release();
    }
}
