package ru.bmstu.rk9;

import java.io.*;
import java.net.Socket;

public class MessageUtils {

    public static void sendMessage(Socket socket, String message) throws IOException {
        OutputStream stream = socket.getOutputStream();
        stream.write(message.getBytes());
        stream.flush();
    }

    public static String getMessage(Socket socket) throws IOException {
        InputStream stream = socket.getInputStream();
        DataInputStream dis = new DataInputStream(stream);
        byte[] buf = new byte[1024];
        String message = "";
        while (dis.read() != -1) {
            dis.read(buf);
            message += new String(buf);
        }
        return message;
    }
}
