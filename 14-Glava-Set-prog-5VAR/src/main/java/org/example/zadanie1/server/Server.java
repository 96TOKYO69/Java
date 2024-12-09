package org.example.zadanie1.server;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Server {
    private static final int PORT = 12345;
    static Set<PrintWriter> clientWriters = new HashSet<>();
    static Map<PrintWriter, String> clientNames = new HashMap<>();
    private static final String SERVER_NAME = "Сервер";

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

    public static void broadcastMessage(String message) {
        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                String clientName = clientNames.get(writer);
                if (clientName == null) {
                    clientName = "Неизвестный клиент";
                }
                writer.println(SERVER_NAME + " отправил сообщение клиенту (" + clientName + "): " + message);
            }
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

                // Чтение имени клиента
                clientName = in.readLine();
                if (clientName == null || clientName.trim().isEmpty()) {
                    clientName = "Неизвестный клиент";
                }
                System.out.println("Клиент подключился: " + clientName);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                    clientNames.put(out, clientName);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Получено от клиента (" + clientName + "): " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                    clientNames.remove(out);
                }
            }
        }
    }
}
