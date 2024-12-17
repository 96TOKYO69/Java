package org.example.zadanie1.server;

import java.util.*;
import java.io.PrintWriter;

public class MessageScheduler {

    public static void scheduleMessagesToClient(String clientName, String message, long delay, long period) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                synchronized (Server.clientWritersByName) {
                    PrintWriter writer = Server.clientWritersByName.get(clientName);
                    if (writer != null) {
                        writer.println("Личное сообщение для " + clientName + ": " + message);
                    } else {
                        System.out.println("Клиент " + clientName + " не найден.");
                    }
                }
            }
        }, delay, period);
    }
}
