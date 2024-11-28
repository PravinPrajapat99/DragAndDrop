package CustomUtility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkStatusChecker {
    public static int getStatusCode(String urlString) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            return connection.getResponseCode();

        } catch (IOException e) {
            return 400;

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
