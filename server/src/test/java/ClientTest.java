import org.junit.Test;
import ru.bmstu.rk9.Server;

import java.io.IOException;

public class ClientTest {

    @Test
    public void testWebServerStart() throws IOException, InterruptedException {
        Thread thread = new Thread(new Server(8081));
        thread.start();
        thread.join();
    }
}
