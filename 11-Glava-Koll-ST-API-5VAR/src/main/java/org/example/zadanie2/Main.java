package org.example.zadanie2;

public class Main {
    public static void main(String[] args) {
        NumberStorage storage = new NumberStorage();

        storage.addNumber(10);
        storage.addNumber(20);
        storage.addNumber(30);

        int target = 25;
        Integer closest = storage.findClosestNumber(target);
        System.out.println("Ближайший номер к " + target + " является: " + closest);

        storage.removeNumber(20);
        System.out.println("Номера после удаления: " + storage.getNumbers());
    }
}
