package com.example.zadanie1test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.net.*;
import java.io.*;

public class ClientServerTest {

    @Test
    public void testClientConnection() {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            assertTrue(socket.isConnected());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMessageReception() throws Exception {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            String message = reader.readLine();
            assertTrue(message.startsWith("Запланированное сообщение в"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
