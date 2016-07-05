import org.junit.Test;
import ru.bmstu.rk9.WebServerThread;

import java.io.IOException;

public class WebServerTest {

    @Test
    public void testWebServerStart() {
        WebServerThread webServer = null;
        try {
            webServer = new WebServerThread(8081);
            Thread thread1 = new Thread(webServer);
            thread1.start();
            thread1.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
