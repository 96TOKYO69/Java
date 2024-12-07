package org.example.zadanie1;

import org.example.zadanie1.server.MessageScheduler;
import org.example.zadanie1.server.Server;

public class App {
    public static void main(String[] args) {
        new Thread(() -> Server.main(args)).start();
        MessageScheduler.scheduleMessages();
    }
}
