package org.example.client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            String message;

            while ((message = reader.readLine()) != null) {
                System.out.println("Полученное сообщение: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
