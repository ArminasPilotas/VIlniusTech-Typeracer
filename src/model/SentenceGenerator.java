<<<<<<< HEAD
package model;

import java.io.IOException;

public class SentenceGenerator {
    private final String searchKeyBegin="result res-sentence'><b>1.&nbsp;&nbsp;";
    private final String searchKeyEnd="</b></p></p></li></ul></div>";
    private final URLConnection urlConnection=new URLConnection();
    private static SentenceGenerator instance;

    public static SentenceGenerator getInstance() throws IOException {
        if(instance==null){
            instance=new SentenceGenerator();
        }
        return instance;
    }
    private SentenceGenerator() throws  IOException{
    }
    public String generateSentence(){
        String html=urlConnection.getHtmlContent();
        if(html==null){
            System.out.println("Failed to generate HTML");
        }
        String sentence=substringSentence(html);
        return decodeHtml(sentence);
    }

    private String decodeHtml(String sentence){
        return sentence.replaceAll("&quot","").trim();
    }
    private String substringSentence(String sentence){
        int beginindex=sentence.indexOf(searchKeyBegin)+searchKeyBegin.length();
        int endindex=sentence.indexOf(searchKeyEnd);
        return sentence.substring(beginindex,endindex);
    }
}
=======
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
>>>>>>> de77b63f8efce10dd1e2a6689b8f03c8e3e5a713
