package org.example.zadanie1.server;

import java.text.SimpleDateFormat;
import java.util.*;

public class MessageScheduler {
    public static void scheduleMessages() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String timestamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
                String message = "Запланированное сообщение в " + timestamp;
                Server.broadcastMessage(message);
            }
        }, 0, 5000);
    }
}
