package examples;

import com.harium.marine.Web;
import com.harium.marine.healthcheck.HealthCheck;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelloWorld {

    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println("Starting Server");

        String host = "localhost";
        int port = 8081;

        Web.port(port);
        Web.host(host);

        String url = "http://" + host + ":" + port + "/health";
        System.out.println("Check server status: " + url);

        Web.staticFileLocation("/public");

        // Register Web Modules
        Web.register(HealthCheck.class);
        // Init Web Modules
        Web.init();

        // Open browser to show the status
        openBrowser(url);
    }

    private static void openBrowser(String url) throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(url));
        }
    }
}
