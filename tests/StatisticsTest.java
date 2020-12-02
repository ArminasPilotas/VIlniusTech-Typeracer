import model.Statistics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StatisticsTest {
    Statistics statistics;

    @Before
    public void setUp() throws IOException {
        statistics=new Statistics();
    }
    @Test
    public void testCalculateWpm(){
        statistics.setSentence("hello world!");
        statistics.calculateWpm(0,"");
        Assert.assertEquals(0,statistics.getWpm());

        statistics.calculateWpm(120,"");
        Assert.assertEquals(0,statistics.getWpm());

        statistics.calculateWpm(60,"hello"); //user types 1 word per 60 seconds(1minute)
        Assert.assertEquals(1,statistics.getWpm());

        statistics.calculateWpm(60,"hello world!"); //user types 2 words per 60 seconds
        Assert.assertEquals(2,statistics.getWpm());
    }
    @Test
    public void testCalculateDonePercentage() {
        statistics.setSentence("ten chars."); //ten characters sentence

        statistics.calculateDonePercentage("");
        Assert.assertEquals(0, statistics.getDonePercentage(), 0.d);

        statistics.calculateDonePercentage("t");
        Assert.assertEquals(10, statistics.getDonePercentage(), 0.d);

        statistics.calculateDonePercentage("ten chars.");
        Assert.assertEquals(100, statistics.getDonePercentage(), 0.d);

        statistics.calculateDonePercentage("sometext"); //incorrect sentence typed
        Assert.assertEquals(0, statistics.getDonePercentage(), 0.d);

        statistics.calculateDonePercentage("tenn"); // partly incorrect sentence typed
        Assert.assertEquals(30, statistics.getDonePercentage(), 0.d);
    }

    @Test
    public void testIfWritingMistake(){
        statistics.setSentence("hello");
        statistics.calculateDonePercentage("");
        Assert.assertFalse(statistics.isWritingMistake());

        statistics.calculateDonePercentage("he");
        Assert.assertFalse(statistics.isWritingMistake());

        statistics.calculateDonePercentage("hello");
        Assert.assertFalse(statistics.isWritingMistake());

        statistics.calculateDonePercentage("hehe");
        Assert.assertTrue(statistics.isWritingMistake());
    }
    @Test
    public void testCalculateAccuracy(){
        statistics.setSentence("ten chars.");
        statistics.calculateDonePercentage("");
        statistics.calculateAccuracy();
        Assert.assertEquals(100,statistics.getAccuracy(),0.0);

        statistics.calculateDonePercentage("ten");
        statistics.calculateAccuracy();
        Assert.assertEquals(100,statistics.getAccuracy(),0.0);

        statistics.calculateDonePercentage("ten chars.");
        statistics.calculateAccuracy();
        Assert.assertEquals(100,statistics.getAccuracy(),0.0);

        statistics.calculateDonePercentage("tenn");
        statistics.calculateAccuracy();
        Assert.assertEquals(90,statistics.getAccuracy(),0.0);

        statistics.setSentence("ten chars.");
        statistics.calculateDonePercentage("tennn");
        statistics.calculateAccuracy();
        Assert.assertEquals(80,statistics.getAccuracy(),0.0);
    }
}
