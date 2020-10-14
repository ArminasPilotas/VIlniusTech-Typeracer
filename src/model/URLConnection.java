package model;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class URLConnection {
    private final String urlPage="https://www.randomwordgenerator.org/Random/sentence_generator?count=30";
    private String htmlContent=null;
    private URL url;
    private java.net.URLConnection connection;

    public URLConnection() throws IOException {
        loadURL();
    }

    private void loadURL() throws IOException {
       URL url = new URL(urlPage);
       connection = url.openConnection();
       connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

    }
    public String getHtmlContent() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = br.readLine()) != null) {
            htmlContent+=inputLine;
        }
        br.close();
        return htmlContent;
    }
}
