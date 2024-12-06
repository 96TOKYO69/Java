package org.example;

public class Main {
    public static void main(String[] args) {

        Route route = new Route(5, 3);

        for (int i = 1; i <= 7; i++) {
            new Bus(i, route).start();
        }
    }
}
