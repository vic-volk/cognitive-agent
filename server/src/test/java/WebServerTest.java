import org.junit.Test;
import ru.bmstu.rk9.WebServer;

import java.io.IOException;

public class WebServerTest {

    @Test
    public void testWebServerStart() throws IOException {
        WebServer webServer = new WebServer();
        webServer.startServer(8081);
    }
}
