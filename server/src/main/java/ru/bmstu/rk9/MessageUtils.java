package ru.bmstu.rk9;

import java.io.*;
import java.net.Socket;

public class MessageUtils {

    public static void sendMessage(Socket socket, String message) throws IOException {
        OutputStream stream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(stream);
        dataOutputStream.writeUTF(message);
        dataOutputStream.flush();
    }

    public static String getMessage(Socket socket) throws IOException {
        InputStream stream = socket.getInputStream();
        DataInputStream dis = new DataInputStream(stream);
        byte[] byteMessage = new byte[1024];
        dis.read(byteMessage);
        String message = new String(byteMessage);
        return message;
    }
}
