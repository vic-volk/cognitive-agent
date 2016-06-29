package ru.bmstu.rk9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer implements Runnable, Cloneable {

    Thread runner = null;
    ServerSocket serverSocket = null;
    Socket data = null;
    volatile boolean shouldStop = false;

    public synchronized void startServer(int port) throws IOException {
        if (runner == null) {
            serverSocket = new ServerSocket(port);
            runner = new Thread(this);
            runner.start();
            System.out.println("Started: start");
        }
    }

    @Override
    public void run() {
        if (serverSocket != null) {
            while (!shouldStop) {
                try {
                    Socket dataSocket = serverSocket.accept();
                    WebServer newServer = (WebServer) clone();

                    newServer.serverSocket = null;
                    newServer.data = dataSocket;
                    newServer.runner = new Thread(newServer);
                    newServer.runner.start();
                    System.out.println("Started: run");
                } catch (Exception e) {}
            }
        } else {
            run(data);
        }

    }

    public void run(Socket data) {
        System.out.println("Test");
    }

    public synchronized void stopServer() {
        if (serverSocket != null) {
            shouldStop = true;
            runner.interrupt();
            runner = null;
            try {
                serverSocket.close();
            } catch (IOException ioe) {}
            serverSocket = null;
        }
    }
}
