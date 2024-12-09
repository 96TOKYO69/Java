package org.example;

import java.util.concurrent.Semaphore;

public class BusStop {
    private final Semaphore semaphore;
    private final String name;

    public BusStop(String name, int capacity) {
        this.name = name;
        this.semaphore = new Semaphore(capacity);
    }

    public void arrive(int busId) throws InterruptedException {
        System.out.printf("Автобус %d ожидает на остановке %s.%n", busId, name);
        semaphore.acquire();
        System.out.printf("Автобус %d остановился на остановке %s.%n", busId, name);
    }

    public void depart(int busId) {
        System.out.printf("Автобус %d покидает остановку %s.%n", busId, name);
        semaphore.release();
    }

    public String getName() {
        return name;
    }
}
