package org.example.server;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            synchronized (Server.clientWriters) {
                Server.clientWriters.add(out);
            }

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from client: " + message);
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
            }
        }
    }
}
