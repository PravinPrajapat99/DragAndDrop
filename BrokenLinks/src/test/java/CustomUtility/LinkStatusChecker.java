package CustomUtility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkStatusChecker {
    public static int getStatusCode(String urlString) {
        HttpURLConnection connection = null;

        try {
            // Create a URL object from the given URL string
            URL url = new URL(urlString);

            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set timeouts to avoid hanging indefinitely
            connection.setConnectTimeout(5000);  // 5 seconds to establish the connection
            connection.setReadTimeout(5000);  // 5 seconds to read data

            // Get the response code

            // Return the response code as a string
            return connection.getResponseCode();

        } catch (IOException e) {
            // Handle the case where the URL cannot be reached or is invalid
            return 400;  // Return the error message

        } finally {
            // Close the connection
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

}
