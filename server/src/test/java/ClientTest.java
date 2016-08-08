import org.junit.Test;
import ru.bmstu.rk9.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTest {

    @Test
    public void testWebServerStart() throws IOException, InterruptedException {
        Thread thread = new Thread(new Server(8081));
        thread.start();
        thread.join();
    }

    @Test
    public void testRunClient() {
        int serverPort = 8081; // здесь обязательно нужно указать порт к которому привязывается сервер.
        String address = "localhost"; // это IP-адрес компьютера, где исполняется наша серверная программа.
        // Здесь указан адрес того самого компьютера где будет исполняться и клиент.

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
            Socket socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
            System.out.println("Yes! I just got hold of the program.");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            System.out.println();

            line = "test line";
            System.out.println("Sending this line to the server...");
            out.writeUTF(line); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            line = in.readUTF(); // ждем пока сервер отошлет строку текста.
            System.out.println("The server was very polite. It sent me this : " + line);
            System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
            System.out.println();

        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
