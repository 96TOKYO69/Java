package org.example;

public class Main {
    public static void main(String[] args) {

        Route route = new Route(3, 2);

        for (int i = 1; i <= 3; i++) {
            new Bus(i, route).start();
        }
    }
}
