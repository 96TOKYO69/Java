package org.example.zadanie1.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 12345;
    static final Set<PrintWriter> clientWriters = new HashSet<>();
    static final Map<PrintWriter, String> clientNames = new HashMap<>();
    static final Map<String, PrintWriter> clientWritersByName = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Сервер запущен на порту " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
