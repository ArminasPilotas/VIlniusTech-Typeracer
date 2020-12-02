import model.URLConnection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class URLConnectionTest {
    URLConnection urlConnection;

    @Before
    public void setUp() throws Exception{
        urlConnection=new URLConnection();
    }
    @Test
    public void testGetHtmlContent(){
        Assert.assertNotNull(urlConnection.getHtmlContent());
    }

}
