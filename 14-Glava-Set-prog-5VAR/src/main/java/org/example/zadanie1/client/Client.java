package org.example.zadanie1.client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
             PrintWriter serverWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true)) {

            System.out.println("Введите ваше имя:");
            String name = consoleReader.readLine();
            serverWriter.println(name);

            System.out.println("Вы подключены к серверу. Ожидание сообщений...");
            String message;

            while ((message = serverReader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
