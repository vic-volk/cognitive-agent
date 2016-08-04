package ru.bmstu.rk9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server implements Runnable {

    ServerSocket serverSocket;
    volatile boolean keepProcessing = true;
    private String simpleResponseMessage = "HTTP/1.1 200 OK\r\n";

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        System.out.println("Server starting");

        while (keepProcessing) {
            try {
                System.out.println("accept client");
                Socket socket = serverSocket.accept();
                System.out.print("got client");
                process(socket);
            } catch (IOException e) {
                handle(e);
            }
        }
    }

    private void handle(Exception e) {
        if (!(e instanceof SocketException)) {
            e.printStackTrace();
        }
    }

    public void stopProcessing() {
        keepProcessing = false;
        closeIgnoringException(serverSocket);
    }

    void process(Socket socket) {
        if (socket == null) {
            return;
        }

        try {
            System.out.println("Server: getting message");
            String message = MessageUtils.getMessage(socket);
            System.out.println("Server: got message: " + message);
            Thread.sleep(1000);
            System.out.println("Server: sending reply: \n" + simpleResponseMessage);
            MessageUtils.sendMessage(socket, simpleResponseMessage);
            System.out.println("Server: sent");
            closeIgnoringException(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeIgnoringException(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    private void closeIgnoringException(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
        }
    }
}
