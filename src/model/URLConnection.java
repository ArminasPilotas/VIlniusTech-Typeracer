package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class URLConnection {
    private final URL urlPage;

    public URLConnection() throws IOException {
        urlPage= new URL ("https://www.randomwordgenerator.org/Random/sentence_generator?count=30");
    }

    private java.net.URLConnection openConnection() throws IOException {
        java.net.URLConnection connection;
       connection = urlPage.openConnection();
       connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        return connection;
    }
    public String getHtmlContent(){
        StringBuilder htmlContent= new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openConnection().getInputStream()));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                htmlContent.append(inputLine);
            }
            br.close();
            return htmlContent.toString();
        }
        catch (IOException exception){
            return null;
        }

    }
}
