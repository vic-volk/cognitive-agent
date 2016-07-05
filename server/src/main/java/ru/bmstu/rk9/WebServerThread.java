package ru.bmstu.rk9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerThread implements Runnable {

    private ServerSocket serverSocket;
    private static final String OUTPUT = "<html><head><title>Example</title></head><body><p>Worked!!!</p></body></html>";
    private static final String OUTPUT_HEADERS = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html\r\n" +
            "Content-Length: ";
    private static final String OUTPUT_END_OF_HEADERS = "\r\n\r\n";
    private static final String OUTPUT_ALL = OUTPUT_HEADERS + OUTPUT.length() + OUTPUT_END_OF_HEADERS + OUTPUT;

    public WebServerThread(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                byte[] buf = new byte[8192];
                while (is.read(buf) > 0) {
                    System.out.println("Input request:");
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(new String(buf));
                }
                OutputStream os = socket.getOutputStream();
                os.write(OUTPUT_HEADERS.getBytes());
                os.flush();
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
