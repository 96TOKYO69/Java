package org.example.zadanie1.server;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
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

            synchronized (Server.clientWriters) {
                Server.clientWriters.add(out);
                Server.clientNames.put(out, clientName);
                Server.clientWritersByName.put(clientName, out);
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
            synchronized (Server.clientWriters) {
                Server.clientWriters.remove(out);
                Server.clientNames.remove(out);
                Server.clientWritersByName.remove(clientName);
            }
        }
    }
}
