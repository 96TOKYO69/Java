package org.example;

import org.example.server.MessageScheduler;
import org.example.server.Server;

public class App {
    public static void main(String[] args) {
        new Thread(() -> Server.main(args)).start();
        MessageScheduler.scheduleMessages();
    }
}
