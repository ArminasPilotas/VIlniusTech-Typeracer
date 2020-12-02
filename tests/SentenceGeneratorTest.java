import model.SentenceGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SentenceGeneratorTest {
    SentenceGenerator sentenceGenerator;
    @Before
    public void setUp() throws Exception{
       sentenceGenerator=SentenceGenerator.getInstance();
    }
    @Test
    public void testGenerateSentenceIfNotNull(){
        Assert.assertNotNull(sentenceGenerator.generateSentence());
    }
    @Test
    public void testGenerateSentenceIfNotEmpty(){
        String sentence=sentenceGenerator.generateSentence();
        Assert.assertTrue(sentence,!sentence.isEmpty());
    }
    @Test
    public void testRegenerateSentence(){ //checks if regenerated sentence is not the same with previous one
        String sentence1=sentenceGenerator.generateSentence();
        String sentence2=sentenceGenerator.generateSentence();
        Assert.assertNotEquals(sentence1,sentence2);
    }
}
