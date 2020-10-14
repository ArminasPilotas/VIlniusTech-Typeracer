package model;

import java.io.IOException;

public class SentenceGenerator {
    protected String sentence=null;
    URLConnection urlConnection=new URLConnection();

    public SentenceGenerator() throws IOException {
        takeSentenceFromHTML();
    }
    private void takeSentenceFromHTML() throws IOException { //takes sentence from raw html
        final String searchKeyBegin="result res-sentence'><b>1.&nbsp;&nbsp;";
        final String searchKeyEnd="</b></p></p></li></ul></div>";
        this.sentence=urlConnection.getHtmlContent();
        this.sentence=sentence.substring(sentence.indexOf(searchKeyBegin)+searchKeyBegin.length(),sentence.indexOf(searchKeyEnd));
        fixSentence();
    }
    private void fixSentence(){ //converts html character entities to normal text
    sentence=sentence.replaceAll("&quot","");
    sentence=sentence.trim();

    }

    public String getSentence() {
        return sentence;
    }
}
