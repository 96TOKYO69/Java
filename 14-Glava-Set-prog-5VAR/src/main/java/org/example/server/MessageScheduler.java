package org.example.server;

import java.util.Timer;
import java.util.TimerTask;

public class MessageScheduler {
    public static void scheduleMessages() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                Server.broadcastMessage("Запланированное сообщение в " + System.currentTimeMillis());
            }
        }, 0, 5000);
    }
}
