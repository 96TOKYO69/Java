package com.example;

import org.example.BusStop;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BusStopTest {

    @Test
    void testSingleBusArrivesAndDeparts() throws InterruptedException {
        BusStop stop = new BusStop(1);
        stop.arrive(1);
        stop.depart(1);

        assertTrue(true, "Автобус успешно прибыл и уехал.");
    }

    @Test
    void testMultipleBusesArriveWithinCapacity() throws InterruptedException {
        BusStop stop = new BusStop(2);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                stop.arrive(1);
                Thread.sleep(1000);
                stop.depart(1);
            } catch (InterruptedException e) {
                fail("Автобус 1 был прерван.");
            }
        });

        executor.submit(() -> {
            try {
                stop.arrive(2);
                Thread.sleep(1000);
                stop.depart(2);
            } catch (InterruptedException e) {
                fail("Автобус 2 был прерван.");
            }
        });

        executor.shutdown();
        assertTrue(executor.awaitTermination(3, TimeUnit.SECONDS), "Все автобусы должны завершить выполнение.");
    }

    @Test
    void testBusWaitsIfCapacityExceeded() throws InterruptedException {
        BusStop stop = new BusStop(1);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                stop.arrive(1);
                Thread.sleep(2000);
                stop.depart(1);
            } catch (InterruptedException e) {
                fail("Автобус 1 был прерван.");
            }
        });
        
        long startTime = System.currentTimeMillis();
        executor.submit(() -> {
            try {
                stop.arrive(2);
                stop.depart(2);
            } catch (InterruptedException e) {
                fail("Автобус 2 был прерван.");
            }
        });

        executor.shutdown();
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS), "Все автобусы должны завершить выполнение.");
        long totalTime = System.currentTimeMillis() - startTime;

        assertTrue(totalTime >= 2000, "Автобус 2 должен был подождать завершения автобуса 1.");
    }
}
