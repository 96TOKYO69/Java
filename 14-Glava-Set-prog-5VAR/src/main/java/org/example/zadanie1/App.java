package org.example.zadanie1;

import org.example.zadanie1.server.MessageScheduler;
import org.example.zadanie1.server.Server;

public class App {
    public static void main(String[] args) {

        new Thread(() -> Server.main(args)).start();

        MessageScheduler.scheduleMessagesToClient(
                "Клиент1",
                "Привет, Клиент1! Это ваше персональное сообщение.",
                0,
                3000
        );

        MessageScheduler.scheduleMessagesToClient(
                "Клиент2",
                "Привет, Клиент2! Это ваше персональное сообщение.",
                2000,
                6000
        );
    }
}
